package HW7_Java_model.q1;

import java.util.HashMap;
import java.util.Map;

import static HW7_Java_model.q1.CharacterText.*;

public class CharacterTextFactory {
    private static Map<String, CharacterText> CHARACTER_BUCKET = new HashMap<>();

    private CharacterTextFactory() {

    }

    // input is like: [char::FONT_FAMILY::COLOR::SIZE]
    // this will be used by the Document Processor
    public static CharacterText parseCharacterAndBuildCharacterText(String serializedCharacter) {
        if (serializedCharacter == null || serializedCharacter.isEmpty()) {
            return null;
        }

        if (CHARACTER_BUCKET.containsKey(serializedCharacter)) {
            return CHARACTER_BUCKET.get(serializedCharacter);
        }

        // characters serialized as [char::FONT_FAMILY::COLOR::SIZE]
        String removedOpenAndClosedBrackets = serializedCharacter.replace(OPEN_BRACKET + "","").replace(CLOSED_BRACKET + "", "");
        Object [] characterProperties = removedOpenAndClosedBrackets.split(DELIMITER);

        Character character = ((String) characterProperties[0]).charAt(0);
        FontFamily fontFamily = FontFamily.createFont((String) characterProperties[1]);
        FontColor fontColor = FontColor.createFontColor((String) characterProperties[2]);
        int fontSize = Integer.parseInt((String) characterProperties[3]);
        CharacterText newCharacter = new CharacterText(character, fontColor, fontFamily, fontSize);

        // put in the cache
        CHARACTER_BUCKET.put(serializedCharacter, newCharacter);

        return newCharacter;
    }

    public static CharacterText buildCharacterText(Character character, FontFamily fontFamily, FontColor fontColor, int fontSize) {
        /**
         *  So like I mentioned in the Question1DriverPart1 each character will be stored with meta data in the file
         *  as [M::ARIAL::BLUE::2], this serialized text will serve as key in the map, since all the characters are stored like this. each combination will yield different format
         */
        String key = DocumentProcessor.serializeCharacter(character, fontFamily, fontColor, fontSize);
        if (CHARACTER_BUCKET.containsKey(key)) {
            return CHARACTER_BUCKET.get(key);
        }
        CharacterText newCharacter = new CharacterText(character, fontColor, fontFamily, fontSize);
        // put in the cache
        CHARACTER_BUCKET.put(key, newCharacter);
        return newCharacter;
    }

}
