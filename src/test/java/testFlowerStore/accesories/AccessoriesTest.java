package testFlowerStore.accesories;

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
import smallflowerstore.modal.pack.DecorativePaper;
import smallflowerstore.modal.pack.Ribbon;

public class AccessoriesTest {

    Thing flower, bouquet;

    @BeforeEach
    void setUp() {

        flower = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        bouquet = new Bouquet();
        ((Bouquet) bouquet).addPackaging(new Packaging((Flower) flower, 7));
    }

    @Test
    @DisplayName("assertEquals getTitle")
    void getTitle() {

        Assertions.assertEquals("Pink peony", flower.getTitle());
        flower = new DecorativePaper(flower);
        Assertions.assertEquals("Pink peony in decorative paper", flower.getTitle());

        Assertions.assertEquals("Bouquet of flower`s 7 pink peonys", bouquet.getTitle());
        bouquet = new DecorativePaper(bouquet);
        Assertions.assertEquals("Bouquet of flower`s 7 pink peonys in decorative paper", bouquet.getTitle());
        bouquet = new Ribbon(bouquet);
        Assertions.assertEquals("Bouquet of flower`s 7 pink peonys in decorative paper with ribbon", bouquet.getTitle());
    }

    @Test
    @DisplayName("assertEquals price")
    void price() {

        Assertions.assertEquals(7.30, flower.price());
        flower = new DecorativePaper(flower);                   // price 7.0
        Assertions.assertEquals(14.30, flower.price());

        Assertions.assertEquals(51.1, bouquet.price()); // price of flowers 7.30 * 7 = 51.10
        bouquet = new DecorativePaper(bouquet);
        Assertions.assertEquals(58.10, bouquet.price()); // 51.10 + 7 = 58.10
        bouquet = new Ribbon(bouquet);                           // price 5.0
        Assertions.assertEquals(63.10, bouquet.price()); // 58.10 + 5 = 63.10
    }
}
