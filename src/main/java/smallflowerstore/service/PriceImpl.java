package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.modal.flower.Thing;

import java.util.LinkedList;

@Getter
@Setter
public class PriceImpl implements Price {

    private LinkedList<Thing> things;

    public PriceImpl() {
        this.things = new LinkedList<>();
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Thing orderThing : things) {
            totalPrice += orderThing.price();
        }
        return totalPrice;
    }

    @Override
    public void addThing(Thing thing) {
        things.add(thing);
    }

    @Override
    public void removeThing(Thing thing) {
        things.remove(thing);
    }

}

