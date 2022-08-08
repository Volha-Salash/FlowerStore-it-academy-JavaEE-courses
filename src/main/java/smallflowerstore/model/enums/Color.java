package smallflowerstore.model.enums;

public enum Color {

    RED("Red"),
    YELLOW("Yellow"),
    BLUE("Blue"),
    WHITE("White"),
    PINK("Pink");

    private final String title;

    Color(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
