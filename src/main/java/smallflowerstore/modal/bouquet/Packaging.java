package smallflowerstore.modal.bouquet;

import lombok.Getter;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;
import smallflowerstore.modal.flower.Flower;

import java.util.Locale;

@Getter
public class Packaging {

    private Flower flower;
    private int amount;

    public Packaging(Flower flower, int amount) {
        this.flower = flower;
        assert (amount > 0);
        this.amount = amount;
    }

    public double getPrice() {
        return flower.price() * amount;
    }

    public Color getColor() {
        return flower.getColor();
    }

    public FlowerType getType() {
        return flower.getType();
    }

    @Override
    public String toString() {
        String str = amount + " " + getColor() + " " + getType() + "s";
        return str.toLowerCase(Locale.ROOT);
    }

    public StemSize getStemSize() {
        return flower.getStemSize();
    }

}

