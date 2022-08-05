package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.bouquet.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.service.Bouquet;
import smallflowerstore.service.PriceImpl;

public class PriceTest {

    PriceImpl price;
    ProductFlowersStore peony, bouquet;

    @BeforeEach
    void setUp() {
        peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Packaging peonyPack = new Packaging((Flower) peony, 7);
        bouquet = new Bouquet();
        ((Bouquet) bouquet).addPackaging(peonyPack);

        price = new PriceImpl();
        price.addProductFlowersStore(bouquet);
    }

    @Test
    @DisplayName("assertEquals calculateTotalPrice")
    void calculateTotalPrice() {
        Assertions.assertEquals(51.1, price.calculateTotalPrice());
        price.addProductFlowersStore(peony);
        Assertions.assertEquals(58.4, price.calculateTotalPrice());
    }


    @Test
    @DisplayName("assertEquals addProductFlowersStore")
    void addProductFlowersStore() {
        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.addProductFlowersStore(peony);
        Assertions.assertEquals(2, price.getProductFlowersStores().size());
        price.addProductFlowersStore(peony);
        Assertions.assertEquals(3, price.getProductFlowersStores().size());
    }

    @Test
    @DisplayName("assertEquals removeProductFlowersStore")
    void removeProductFlowersStore() {

        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.removeProductFlowersStore(peony); //ProductFlowersStore(flower) isn't in your bouquet
        Assertions.assertEquals(1, price.getProductFlowersStores().size());
        price.removeProductFlowersStore(bouquet);
        assert price.getProductFlowersStores().isEmpty();
    }
}

