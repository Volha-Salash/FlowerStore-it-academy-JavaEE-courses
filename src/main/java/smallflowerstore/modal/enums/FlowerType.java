package smallflowerstore.modal.enums;

public enum FlowerType {
    ROSE("Rose"),
    PEONY("Peony"),
    CHRYSANTHEMUM("Chrysanthemum"),
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
