public enum Color {
    BLACK, WHITE;

    public String getColorStr() {
        switch (this) {
            case BLACK:
                return "b";
            case WHITE:
                return "w";
            default:
                return null;
        }
    }
};