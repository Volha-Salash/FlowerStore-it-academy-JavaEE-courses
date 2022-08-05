package smallflowerstore.modal.pack;

import smallflowerstore.modal.flower.Thing;

public class Accessories extends Thing {

    private Thing thing;

    public Accessories(Thing thing) {
        this.thing = thing;
    }

    @Override
    public String getTitle() {
        return thing.getTitle();
    }

    @Override
    public double price() {
        return thing.price();
    }
}
