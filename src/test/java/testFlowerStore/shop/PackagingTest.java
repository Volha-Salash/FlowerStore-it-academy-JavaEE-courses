package testFlowerStore.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;


class PackagingTest {
    Packaging pack;
    Flower peony;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        pack = new Packaging(peony, 5);
    }

    @Test
    @DisplayName("assertEquals getPrice")
    void getPriceTest() {
        Assertions.assertEquals(36.5, pack.getPrice());
        peony.setPrice(4.0);
        Assertions.assertEquals(20.0, pack.getPrice());
    }

    @Test
    @DisplayName("assertEquals getColor")
    void getColorTest() {
        Assertions.assertEquals(Color.PINK, pack.getColor());
        peony.setColor(Color.RED);
        Assertions.assertEquals(Color.RED, pack.getColor());
    }

    @Test
    @DisplayName("assertEquals getFlower")
    void getFlowerTest() {
        Assertions.assertEquals(peony, pack.getFlower());
        peony.setPrice(5.0);
        Assertions.assertEquals(peony, pack.getFlower());
    }

}
