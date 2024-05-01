package HW7_Java_model.q1;


import java.util.List;

public class Document {
    private String fileName;
    private String serializedText;
    private String deserializedText;
    private List<CharacterText> deserializedCharacters;

    public Document(String fileName, String serializedText, String deserializedText, List<CharacterText> deserializedCharacters) {
        this.fileName = fileName;
        this.serializedText = serializedText;
        this.deserializedText = deserializedText;
        this.deserializedCharacters = deserializedCharacters;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSerializedText() {
        return serializedText;
    }

    public void setSerializedText(String serializedText) {
        this.serializedText = serializedText;
    }

    public List<CharacterText> getDeserializedCharacters() {
        return deserializedCharacters;
    }

    public void setDeserializedCharacters(List<CharacterText> deserializedCharacters) {
        this.deserializedCharacters = deserializedCharacters;
    }

    public String getDeserializedText() {
        return deserializedText;
    }

    public void setDeserializedText(String deserializedText) {
        this.deserializedText = deserializedText;
    }
}
