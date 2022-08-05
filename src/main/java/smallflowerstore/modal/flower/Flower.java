package smallflowerstore.modal.flower;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;

import java.util.Locale;

@Getter
@Setter
public class Flower extends Thing {

    private FlowerType type;
    private Color color;
    private double price;
    private StemSize stemSize;
    private boolean isFresh;

    public Flower(FlowerType type, Color color, double price, StemSize stemSize, boolean isFresh) {
        this.stemSize = stemSize;
        this.price = price;
        this.color = color;
        this.type = type;
        this.isFresh = isFresh;
        changeTitle();
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String title = color + " " + type;
        return title.charAt(0) + title.toLowerCase(Locale.ROOT).substring(1);
    }

}