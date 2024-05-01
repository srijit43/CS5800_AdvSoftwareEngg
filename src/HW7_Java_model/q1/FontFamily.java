package HW7_Java_model.q1;

public enum FontFamily {
    ARIAL,
    TIMES_ROMAN,
    VERDANA;

    public static FontFamily createFont(String font) {
        if (font == null) {
            return null;
        }
        font = font.toUpperCase();
        switch (font) {
            case "ARIAL" :
                return ARIAL;
            case "TIMES_ROMAN" :
                return TIMES_ROMAN;
            case "VERDANA" :
                return VERDANA;
            default:
                return null;
        }
    }
}