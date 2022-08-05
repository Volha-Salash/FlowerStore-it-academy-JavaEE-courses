package smallflowerstore.model.enums;

public enum FlowerType {
    ROSE("Rose"),
    PEONY("Peony"),
    HYDRANGEA("Hydrangea");

    private String title;


    FlowerType(String title) {
        this.title = title;

    }

    @Override
    public String toString() {
        return title;
    }

}
