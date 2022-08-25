package smallflowerstore.model;

public abstract class ProductFlowersStore {

    String title;
    double price;

    public String getTitle() {
        return title;
    }

    public void changeTitle() {
        this.title = toString();
    }

    public double price() {
        return price;
    }

}
