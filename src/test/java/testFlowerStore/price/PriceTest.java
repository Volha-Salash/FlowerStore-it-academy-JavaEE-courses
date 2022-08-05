package testFlowerStore.price;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.modal.bouquet.Bouquet;
import smallflowerstore.modal.bouquet.Packaging;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;
import smallflowerstore.modal.flower.Flower;
import smallflowerstore.modal.flower.Thing;
import smallflowerstore.service.PriceImpl;

public class PriceTest {

    PriceImpl price;
    Thing peony, bouquet;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Packaging peony_pack = new Packaging((Flower) peony, 7);
        bouquet = new Bouquet();
        ((Bouquet) bouquet).addPackaging(peony_pack);

        price = new PriceImpl();
        price.addThing(bouquet);
    }

    @Test
    @DisplayName("assertEquals calculateTotalPrice")
    void calculateTotalPrice() {
        Assertions.assertEquals(51.1, price.calculateTotalPrice());
        price.addThing(peony);
        Assertions.assertEquals(58.4, price.calculateTotalPrice());
    }


    @Test
    @DisplayName("assertEquals addThing")
    void addThing() {
        Assertions.assertEquals(1, price.getThings().size());
        price.addThing(peony);
        Assertions.assertEquals(2, price.getThings().size());
        price.addThing(peony);
        Assertions.assertEquals(3, price.getThings().size());
    }

    @Test
    @DisplayName("assertEquals removeThing")
    void removeThing() {

        Assertions.assertEquals(1, price.getThings().size());
        price.removeThing(peony); //subject/thing isn't in your bouquet
        Assertions.assertEquals(1, price.getThings().size());
        price.removeThing(bouquet);
        assert price.getThings().isEmpty();
    }
}

