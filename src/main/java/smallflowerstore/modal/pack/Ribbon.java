package smallflowerstore.modal.pack;

import smallflowerstore.modal.flower.Thing;

public class Ribbon extends Accessories{
    public Ribbon(Thing thing) {
        super(thing);
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " with ribbon";
    }

    @Override
    public double price() {
        return super.price() + 5;
    }
}
