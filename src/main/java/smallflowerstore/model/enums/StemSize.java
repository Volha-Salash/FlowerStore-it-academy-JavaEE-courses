package smallflowerstore.model.enums;

public enum StemSize {
    SHORT(35),
    MIDDLE(45),
    LONG(70);

    private int stemSize;

    StemSize(int stemSize) {
        this.stemSize = stemSize;
    }

    @Override
    public String toString() {
        return "StemSize{" +
                "stemSize=" + stemSize +
                '}';
    }
}

