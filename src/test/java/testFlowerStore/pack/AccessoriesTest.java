package testFlowerStore.pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.model.pack.DecorativePaper;
import smallflowerstore.model.pack.Ribbon;
import smallflowerstore.service.BouquetService;

class AccessoriesTest {

    ProductFlowersStore flower;
    ProductFlowersStore bouquet;

    @BeforeEach
    void setUp() {

        flower = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        bouquet = new BouquetService();
        ((BouquetService) bouquet).addPackaging(new Packaging((Flower) flower, 7));
    }

    @Test
    @DisplayName("assertEquals getTitle")
    void getTitleTest() {

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
    void priceTest() {

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
