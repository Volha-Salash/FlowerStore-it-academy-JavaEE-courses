package smallflowerstore.service;

import smallflowerstore.modal.flower.Thing;

public interface Price {

    public double calculateTotalPrice();

    public void addThing(Thing thing);

    public void removeThing(Thing thing);

}
