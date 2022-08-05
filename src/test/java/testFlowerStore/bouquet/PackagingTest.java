package testFlowerStore.bouquet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.modal.bouquet.Packaging;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;
import smallflowerstore.modal.flower.Flower;

public class PackagingTest {
    Packaging pack;
    Flower peony;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        pack = new Packaging(peony, 5);
    }

    @Test
    @DisplayName("assertEquals getPrice")
    void getPrice() {
        Assertions.assertEquals(36.5, pack.getPrice());
        peony.setPrice(4.0);
        Assertions.assertEquals(20, pack.getPrice());
    }

    @Test
    @DisplayName("assertEquals getColor")
    void getColor() {
        Assertions.assertEquals(Color.PINK, pack.getColor());
        peony.setColor(Color.RED);
        Assertions.assertEquals(Color.RED, pack.getColor());
    }

    @Test
    @DisplayName("assertEquals getFlower")
    void getFlower() {
        Assertions.assertEquals(peony, pack.getFlower());
        peony.setPrice(5.0);
        Assertions.assertEquals(peony, pack.getFlower());
    }


}
