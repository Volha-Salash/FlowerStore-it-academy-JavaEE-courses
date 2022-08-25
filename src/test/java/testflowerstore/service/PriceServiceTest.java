package testflowerstore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.model.shop.Bouquet;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.service.BouquetService;
import smallflowerstore.service.PriceService;

class PriceServiceTest {

    PriceService price;
    ProductFlowersStore peony, bouquet;
    BouquetService bouquetService;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Packaging peonyPack = new Packaging((Flower) peony, 7);
        bouquet = new Bouquet();
        ((Bouquet) bouquet).addPackaging(peonyPack);
        bouquetService = new BouquetService();
        price = new PriceService();
        price.getPrice().addProductFlowersStore(bouquet);
    }

    @Test
    @DisplayName("assertEquals calculateTotalPrice")
    void calculateTotalPriceTest() {
        Assertions.assertEquals(51.1, bouquetService.price((Bouquet) bouquet));
        peony = new Flower(FlowerType.PEONY, Color.PINK, 5.0, StemSize.MIDDLE, true);
        Assertions.assertEquals(56.1, bouquetService.price((Bouquet) bouquet) + peony.price());
    }


    @Test
    @DisplayName("assertEquals addProductFlowersStore")
    void addProductFlowersStoreTest() {
        Assertions.assertEquals(1, price.getPrice().getProductFlowersStores().size());
        price.getPrice().addProductFlowersStore(peony);
        Assertions.assertEquals(2, price.getPrice().getProductFlowersStores().size());
        price.getPrice().removeProductFlowersStore(peony);
        Assertions.assertEquals(1, price.getPrice().getProductFlowersStores().size());
    }

    @Test
    @DisplayName("assertEquals removeProductFlowersStore")
    void removeProductFlowersStoreTest() {

        Assertions.assertEquals(1, price.getPrice().getProductFlowersStores().size());
        price.getPrice().removeProductFlowersStore(peony); //ProductFlowersStore(flower) isn't in your bouquet
        Assertions.assertEquals(1, price.getPrice().getProductFlowersStores().size());
        price.getPrice().removeProductFlowersStore(bouquet);
        assert price.getPrice().getProductFlowersStores().isEmpty();
    }
}

