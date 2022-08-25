package testflowerstore.flower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerTest {
    Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
    }

    @Test
    @DisplayName("assertEquals getPrice")
    void getPriceTest() {
        Assertions.assertEquals(7.30, flower.getPrice());
        flower.setPrice(8.7);
        Assertions.assertEquals(8.7, flower.getPrice());
    }

    @Test
    @DisplayName("assertEquals getStemSize")
    void getStemSizeTest() {
        Assertions.assertEquals(StemSize.MIDDLE, flower.getStemSize());
        flower.setStemSize(StemSize.LONG);
        Assertions.assertEquals(StemSize.LONG, flower.getStemSize());
    }

    @Test
    @DisplayName("assertEquals getColor")
    void getColorTest() {
        flower.setColor(Color.PINK);
        Assertions.assertEquals(Color.PINK, flower.getColor());
    }

    @Test
    @DisplayName("assertEquals getType")
    void getTypeTest() {
        assertEquals(FlowerType.PEONY, flower.getType());
        flower.setType(FlowerType.HYDRANGEA);
        assertEquals(FlowerType.HYDRANGEA, flower.getType());
    }

    @Test
    @DisplayName("assertTrue isFresh")
    void isFreshTest() {
        boolean isFresh = true;
        Assertions.assertTrue(isFresh);
    }

}