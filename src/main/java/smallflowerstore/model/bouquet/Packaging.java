package smallflowerstore.model.bouquet;

import lombok.Getter;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;

import java.util.Locale;

@Getter
public class Packaging {

    private final Flower flower;
    private final int amount;

    public Packaging(Flower flower, int amount) {
        this.flower = flower;
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

