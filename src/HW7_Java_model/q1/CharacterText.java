package HW7_Java_model.q1;


public class CharacterText {
    private Character character;
    private FontColor color;
    private FontFamily fontFamily;
    private int size;
    public final static String DELIMITER = "::";
    public final static Character OPEN_BRACKET = '[';
    public final static Character CLOSED_BRACKET = ']';

    public final static Character SPACE = '%';
    public CharacterText(Character character, FontColor color, FontFamily fontFamily, int size) {
        this.character = character;
        this.color = color;
        this.fontFamily = fontFamily;
        this.size = size;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public FontColor getColor() {
        return color;
    }

    public void setColor(FontColor color) {
        this.color = color;
    }

    public FontFamily getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(FontFamily fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSerializedText() {
        return new StringBuilder().append(OPEN_BRACKET)
                .append(character)
                .append(DELIMITER)
                .append(fontFamily.toString())
                .append(DELIMITER)
                .append(character)
                .append(DELIMITER)
                .append(size)
                .append(CLOSED_BRACKET).toString();
    }
}