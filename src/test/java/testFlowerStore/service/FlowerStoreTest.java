package testFlowerStore.service;

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
import smallflowerstore.service.FlowerStore;

import java.util.HashSet;

class FlowerStoreTest {
    FlowerStore flowerStore;
    Bouquet cheap_bouquet;
    Bouquet expensive_bouquet;
    Bouquet hudragea_bouquet;      // with one kind of flowers
    Bouquet monochromatic_bouquet; // with the same color

    @BeforeEach
    void setUp() {
        flowerStore = new FlowerStore();

        cheap_bouquet = new Bouquet();
        expensive_bouquet = new Bouquet();
        hudragea_bouquet = new Bouquet();
        monochromatic_bouquet = new Bouquet();

        Flower white_rose = new Flower(FlowerType.ROSE, Color.WHITE, 12.0, StemSize.LONG, true);
        Flower red_rose = new Flower(FlowerType.ROSE, Color.RED, 12.0, StemSize.LONG, true);
        Flower pink_peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Flower pink_hydragea = new Flower(FlowerType.HYDRANGEA, Color.PINK, 18.0, StemSize.MIDDLE, true);

        cheap_bouquet.addPackaging(new Packaging(pink_peony, 3)); // price 7.30 * 3 = 21.9
        expensive_bouquet.addPackaging(new Packaging(red_rose, 70)); // price 12.00 * 70 + 12.0 * 31 = 1212.0
        expensive_bouquet.addPackaging(new Packaging(white_rose, 31));
        hudragea_bouquet.addPackaging(new Packaging(pink_hydragea, 5)); // price 18.0 * 5 = 90.0
        monochromatic_bouquet.addPackaging(new Packaging(pink_peony, 5)); // price 7.30 * 5 + 18.0 * 6 = 144.5
        monochromatic_bouquet.addPackaging(new Packaging(pink_hydragea, 6));

        flowerStore.addBouquet(monochromatic_bouquet);
        flowerStore.addBouquet(expensive_bouquet);
        flowerStore.addBouquet(cheap_bouquet);
        flowerStore.addBouquet(hudragea_bouquet);
    }

    @Test
    @DisplayName("assertEquals addBouquet")
    void addBouquet() {
        Bouquet new_bouquet = new Bouquet();

        HashSet<Bouquet> bouquets = flowerStore.getBouquets();
        Assertions.assertEquals(4, bouquets.size());
        assert (!bouquets.contains(new_bouquet));

        flowerStore.addBouquet(new_bouquet);
        bouquets = flowerStore.getBouquets();
        Assertions.assertEquals(5, bouquets.size());
        assert (bouquets.contains(new_bouquet));

        flowerStore.addBouquet(new_bouquet);
        bouquets = flowerStore.getBouquets();
        Assertions.assertEquals(5, bouquets.size());
    }

    @Test
    @DisplayName("assertEquals rangeByPrice")
    void rangeByPrice() {
        HashSet<Bouquet> bouquets = flowerStore.assortment(20, 150); // assortment of bouquets with price [20, 150]
        Assertions.assertEquals(3, bouquets.size());
        assert (bouquets.contains(cheap_bouquet));
        assert (bouquets.contains(monochromatic_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByColor")
    void rangeByColor() {
        Color[] colors = {Color.WHITE, Color.RED};
        HashSet<Bouquet> bouquets = flowerStore.assortment(colors); //assortment of bouquets with color white, red
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensive_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByStemSize")
    void rangeStemSize() {
        StemSize[] stemSizes = {StemSize.LONG};
        HashSet<Bouquet> bouquets = flowerStore.assortment(stemSizes); //assortment of bouquets with sizes of stem long
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensive_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByType")
    void rangeByType() {
        FlowerType[] types = {FlowerType.HYDRANGEA, FlowerType.PEONY};
        HashSet<Bouquet> bouquets = flowerStore.assortment(types); //assortment of bouquets with types: HYDRANGEA, PEONY
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(monochromatic_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColor")
    void rangeByPriceColor() {
        Color[] colors = {Color.PINK};
        HashSet<Bouquet> bouquets = flowerStore.assortment(50, 1500, colors);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(monochromatic_bouquet));
        assert (bouquets.contains(hudragea_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceType")
    void rangeByPriceType() {
        FlowerType[] types = {FlowerType.ROSE};
        HashSet<Bouquet> bouquets = flowerStore.assortment(10, 100, types); //assortment of bouquets with price is min 10,  max 100, type: rose
        Assertions.assertNotEquals(1, bouquets.size());
        assert (bouquets.isEmpty());
    }

    @Test
    @DisplayName("assertEquals rangeByColorType")
    void rangeByColorType() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        HashSet<Bouquet> bouquets = flowerStore.assortment(colors, types); //assortment of bouquets with color: pink, type: peony;
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheap_bouquet));
        assert (bouquets.contains(monochromatic_bouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColorType")
    void rangeByPriceColorType() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        HashSet<Bouquet> bouquets = flowerStore.assortment(0, 1300, colors, types, null);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheap_bouquet));

    }

}
