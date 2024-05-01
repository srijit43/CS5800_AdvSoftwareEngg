package HW7_Java_model.q1;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static HW7_Java_model.q1.CharacterText.*;

public class DocumentProcessor {

    private static final String FILE_BASE_PATH = "C:\\Users\\sriji\\CS5800AdvSWE\\";

    private DocumentProcessor() {

    }

    public static void createDocument(String documentName, String content, FontFamily fontFamily, FontColor color, int fontSize) {
        content = content.trim();
        String serializedText = serializeText(content, fontFamily, color, fontSize);
        createFile(FILE_BASE_PATH + documentName, serializedText);
    }

    public static void updateDocument(String documentName, String newContent, FontFamily fontFamily, FontColor color, int fontSize) {
        newContent = newContent.trim();
        String serializedText = serializeText(newContent, fontFamily, color, fontSize);
        createFile(FILE_BASE_PATH + documentName, serializedText);
    }

    public static Document getDocument(String documentPath) {
        String serializedText = readFile(FILE_BASE_PATH + documentPath);
        List<CharacterText> characterTexts = deserializeTextAndBuildCharacterTextList(serializedText);
        String rawText = buildRawText(characterTexts);
        return new Document(documentPath, serializedText, rawText, characterTexts);
    }

    public static Document buildDocumentObject(String documentName, String content, FontFamily fontFamily, FontColor color, int fontSize) {
        String serializedText = serializeText(content, fontFamily, color, fontSize);
        List<CharacterText> characterTexts = deserializeTextAndBuildCharacterTextList(serializedText);
        return new Document(FILE_BASE_PATH + documentName, serializedText, content, characterTexts);
    }

    private static void createFile(String filePath, String serializedContent) {
        try {
            File myObj = new File(filePath);
            myObj.createNewFile();
            writeToFile(filePath, serializedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String filePath, String serializedContent) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(serializedContent);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) {
        StringBuilder serializedText = new StringBuilder();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                serializedText.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return serializedText.toString();
    }

    public static String buildRawText(List<CharacterText> characterTexts) {
        StringBuilder rawText = new StringBuilder();
        characterTexts.forEach(characterText -> rawText.append(characterText.getCharacter() == SPACE ? ' ' : characterText.getCharacter()));
        return rawText.toString();
    }

    public static String serializeText(String text, FontFamily fontFamily, FontColor color, int size) {
        text = text.trim();
        StringBuilder serializedText =  new StringBuilder();
        int index = 0;

        while(index < text.length()) {
            Character currentCharacter = text.charAt(index);
            if (currentCharacter.equals(' ')) {
                serializedText.append(CharacterText.SPACE);
            }
            else {
                // serialize the character
                serializedText.append(serializeCharacter(currentCharacter, fontFamily, color, size));
            }
            index++;
        }
        return serializedText.toString();
    }

    public static List<CharacterText> deserializeTextAndBuildCharacterTextList(String serializedText) {
        serializedText = serializedText.trim();
        int index = 0;
        StringBuilder currentSerializedCharacter = new StringBuilder();
        List<CharacterText> deserializedCharacters = new ArrayList<>();

        while(index < serializedText.length()) {
            Character currentChar = serializedText.charAt(index);
            if (Character.compare(currentChar, OPEN_BRACKET) == 0) {
                // flush out the old string
                currentSerializedCharacter = new StringBuilder();
                // character begins
                currentSerializedCharacter.append(currentChar);
            } else if ((Character.compare(currentChar, CLOSED_BRACKET) == 0)) {
                // character ends
                currentSerializedCharacter.append(currentChar);
                // create new character object from the character factory [Flyweight pattern is being used here!!!]
                deserializedCharacters.add(CharacterTextFactory.parseCharacterAndBuildCharacterText(currentSerializedCharacter.toString()));
            } else if ((Character.compare(currentChar, SPACE) == 0)) {
                // space [Flyweight pattern is being used here!!!]
                deserializedCharacters.add(CharacterTextFactory.parseCharacterAndBuildCharacterText("[%::FONT_FAMILY::COLOR::1]"));
            } else {
                // just append the string
                currentSerializedCharacter.append(currentChar);
            }
            index++;
        }
        return deserializedCharacters;
    }

    public static String serializeCharacter(Character character, FontFamily fontFamily, FontColor color, int size) {
        return new StringBuilder().append(OPEN_BRACKET)
                .append(character)
                .append(DELIMITER)
                .append(fontFamily.toString())
                .append(DELIMITER)
                .append(color.toString())
                .append(DELIMITER)
                .append(size)
                .append(CLOSED_BRACKET).toString();
    }
}