package smallflowerstore.modal.flower;

public abstract class Thing {

    String title;

    public Thing() {
    }

    public String getTitle() {
        return title;
    }

    public void changeTitle() {
        this.title = toString();
    }

    public abstract double price();

}
