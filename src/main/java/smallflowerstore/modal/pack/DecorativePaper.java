package smallflowerstore.modal.pack;

import smallflowerstore.modal.flower.Thing;

public class DecorativePaper extends Accessories{

    public DecorativePaper(Thing thing) {
        super(thing);
    }

    @Override
    public double price() {
        return super.price() + 7;
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " in decorative paper";
    }
}
