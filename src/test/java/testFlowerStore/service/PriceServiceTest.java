package testFlowerStore.service;

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
import smallflowerstore.service.BouquetService;
import smallflowerstore.service.PriceService;

class PriceServiceTest {

    PriceService price;
    ProductFlowersStore peony, bouquet;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Packaging peonyPack = new Packaging((Flower) peony, 7);
        bouquet = new BouquetService();
        ((BouquetService) bouquet).addPackaging(peonyPack);

        price = new PriceService();
        price.addProductFlowersStore(bouquet);
    }

    @Test
    @DisplayName("assertEquals calculateTotalPrice")
    void calculateTotalPriceTest() {
        Assertions.assertEquals(51.1, price.calculateTotalPrice());
        price.addProductFlowersStore(peony);
        Assertions.assertEquals(58.4, price.calculateTotalPrice());
    }


    @Test
    @DisplayName("assertEquals addProductFlowersStore")
    void addProductFlowersStoreTest() {
        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.addProductFlowersStore(peony);
        Assertions.assertEquals(2, price.getProductFlowersStores().size());
        price.removeProductFlowersStore(peony);
        Assertions.assertEquals(1, price.getProductFlowersStores().size());
    }

    @Test
    @DisplayName("assertEquals removeProductFlowersStore")
    void removeProductFlowersStoreTest() {

        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.removeProductFlowersStore(peony); //ProductFlowersStore(flower) isn't in your bouquet
        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.removeProductFlowersStore(bouquet);
        assert price.getProductFlowersStores().isEmpty();
    }
}

