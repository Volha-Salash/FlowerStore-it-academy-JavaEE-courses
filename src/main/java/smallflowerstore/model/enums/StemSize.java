package smallflowerstore.model.enums;

public enum StemSize {
    SHORT(35),
    MIDDLE(45),
    LONG(70);

    private final int steamSize;

    StemSize(int stemSize) {
        this.steamSize = stemSize;
    }

    @Override
    public String toString() {
        return "SteamSize{" +
                "steamSize=" + steamSize +
                '}';
    }
}

