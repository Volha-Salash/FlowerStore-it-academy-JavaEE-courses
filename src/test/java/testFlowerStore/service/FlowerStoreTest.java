package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.bouquet.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.service.Bouquet;
import smallflowerstore.service.FlowerStore;

import java.util.Set;

class FlowerStoreTest {
    FlowerStore flowerStore;
    Bouquet cheapBouquet;
    Bouquet expensiveBouquet;
    Bouquet hudrageaBouquet;      // with one kind of flowers
    Bouquet monochromaticBouquet; // with the same color

    @BeforeEach
    void setUp() {
        flowerStore = new FlowerStore();

        cheapBouquet = new Bouquet();
        expensiveBouquet = new Bouquet();
        hudrageaBouquet = new Bouquet();
        monochromaticBouquet = new Bouquet();

        Flower whiteRose = new Flower(FlowerType.ROSE, Color.WHITE, 12.0, StemSize.LONG, true);
        Flower redRose = new Flower(FlowerType.ROSE, Color.RED, 12.0, StemSize.LONG, true);
        Flower pinkPeony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Flower pinkHydragea = new Flower(FlowerType.HYDRANGEA, Color.PINK, 18.0, StemSize.MIDDLE, true);

        cheapBouquet.addPackaging(new Packaging(pinkPeony, 3)); // price 7.30 * 3 = 21.9
        expensiveBouquet.addPackaging(new Packaging(redRose, 70)); // price 12.00 * 70 + 12.0 * 31 = 1212.0
        expensiveBouquet.addPackaging(new Packaging(whiteRose, 31));
        hudrageaBouquet.addPackaging(new Packaging(pinkHydragea, 5)); // price 18.0 * 5 = 90.0
        monochromaticBouquet.addPackaging(new Packaging(pinkPeony, 5)); // price 7.30 * 5 + 18.0 * 6 = 144.5
        monochromaticBouquet.addPackaging(new Packaging(pinkHydragea, 6));

        flowerStore.addBouquet(monochromaticBouquet);
        flowerStore.addBouquet(expensiveBouquet);
        flowerStore.addBouquet(cheapBouquet);
        flowerStore.addBouquet(hudrageaBouquet);
    }

    @Test
    @DisplayName("assertEquals addBouquet")
    void addBouquet() {
        Bouquet new_bouquet = new Bouquet();

        Set<Bouquet> bouquets = flowerStore.getBouquets();
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
        Set<Bouquet> bouquets = flowerStore.assortment(20, 150); // assortment of bouquets with price [20, 150]
        Assertions.assertEquals(3, bouquets.size());
        assert (bouquets.contains(cheapBouquet));
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByColor")
    void rangeByColor() {
        Color[] colors = {Color.WHITE, Color.RED};
        Set<Bouquet> bouquets = flowerStore.assortment(colors); //assortment of bouquets with color white, red
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensiveBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByStemSize")
    void rangeStemSize() {
        StemSize[] stemSizes = {StemSize.LONG};
        Set<Bouquet> bouquets = flowerStore.assortment(stemSizes); //assortment of bouquets with sizes of stem long
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensiveBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByType")
    void rangeByType() {
        FlowerType[] types = {FlowerType.HYDRANGEA, FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStore.assortment(types); //assortment of bouquets with types: HYDRANGEA, PEONY
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColor")
    void rangeByPriceColor() {
        Color[] colors = {Color.PINK};
        Set<Bouquet> bouquets = flowerStore.assortment(50, 1500, colors);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(monochromaticBouquet));
        assert (bouquets.contains(hudrageaBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceType")
    void rangeByPriceType() {
        FlowerType[] types = {FlowerType.ROSE};
        Set<Bouquet> bouquets = flowerStore.assortment(10, 100, types); //assortment of bouquets with price is min 10,  max 100, type: rose
        Assertions.assertNotEquals(1, bouquets.size());
        assert (bouquets.isEmpty());
    }

    @Test
    @DisplayName("assertEquals rangeByColorType")
    void rangeByColorType() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStore.assortment(colors, types); //assortment of bouquets with color: pink, type: peony;
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheapBouquet));
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColorType")
    void rangeByPriceColorType() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStore.assortment(0, 1300, colors, types, null);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheapBouquet));

    }

}
