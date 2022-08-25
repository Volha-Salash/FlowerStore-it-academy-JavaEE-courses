package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.model.shop.Bouquet;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.service.FlowerStoreService;

import java.util.Set;

class FlowerStoreServiceTest {
    FlowerStoreService flowerStoreService;
    Bouquet cheapBouquet;
    Bouquet expensiveBouquet;
    Bouquet hydrangeaBouquet;      // with one kind of flowers
    Bouquet monochromaticBouquet; // with the same color


    @BeforeEach
    void setUp() {
        flowerStoreService = new FlowerStoreService();
        Set<Bouquet> bouquets;
        cheapBouquet = new Bouquet();
        expensiveBouquet = new Bouquet();
        hydrangeaBouquet = new Bouquet();
        monochromaticBouquet = new Bouquet();

        Flower whiteRose = new Flower(FlowerType.ROSE, Color.WHITE, 12.0, StemSize.LONG, true);
        Flower redRose = new Flower(FlowerType.ROSE, Color.RED, 12.0, StemSize.LONG, true);
        Flower pinkPeony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Flower pinkHydrangea = new Flower(FlowerType.HYDRANGEA, Color.PINK, 18.0, StemSize.MIDDLE, true);

        cheapBouquet.addPackaging(new Packaging(pinkPeony, 3)); // price 7.30 * 3 = 21.9
        expensiveBouquet.addPackaging(new Packaging(redRose, 70)); // price 12.00 * 70 + 12.0 * 31 = 1212.0
        expensiveBouquet.addPackaging(new Packaging(whiteRose, 31));
        hydrangeaBouquet.addPackaging(new Packaging(pinkHydrangea, 5)); // price 18.0 * 5 = 90.0
        monochromaticBouquet.addPackaging(new Packaging(pinkPeony, 5)); // price 7.30 * 5 + 18.0 * 6 = 144.5
        monochromaticBouquet.addPackaging(new Packaging(pinkHydrangea, 6));

        flowerStoreService.getFlowerStore().addBouquet(monochromaticBouquet);
        flowerStoreService.getFlowerStore().addBouquet(expensiveBouquet);
        flowerStoreService.getFlowerStore().addBouquet(cheapBouquet);
        flowerStoreService.getFlowerStore().addBouquet(hydrangeaBouquet);
    }

    @Test
    @DisplayName("assertEquals addBouquet")
    void addBouquetTest() {
        Bouquet new_bouquetService = new Bouquet();

        Set<Bouquet> bouquets = flowerStoreService.getFlowerStore().getBouquets();
        Assertions.assertEquals(4, bouquets.size());
        assert (!bouquets.contains(new_bouquetService));

        flowerStoreService.getFlowerStore().addBouquet(new_bouquetService);
        bouquets = flowerStoreService.getFlowerStore().getBouquets();
        Assertions.assertEquals(5, bouquets.size());
        assert (bouquets.contains(new_bouquetService));

        flowerStoreService.getFlowerStore().addBouquet(new_bouquetService);
        bouquets = flowerStoreService.getFlowerStore().getBouquets();
        Assertions.assertEquals(5, bouquets.size());
    }

    @Test
    @DisplayName("assertEquals rangeByPrice")
    void rangeByPriceTest() {
        Set<Bouquet> bouquets = flowerStoreService.assortment(20, 150); // assortment of bouquets with price [20, 150]
        Assertions.assertEquals(3, bouquets.size());
        assert (bouquets.contains(cheapBouquet));
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByColor")
    void rangeByColorTest() {
        Color[] colors = {Color.WHITE, Color.RED};
        Set<Bouquet> bouquets = flowerStoreService.assortment(colors); //assortment of bouquets with color white, red
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensiveBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByStemSize")
    void rangeStemSizeTest() {
        StemSize[] stemSizes = {StemSize.LONG};
        Set<Bouquet> bouquets;
        bouquets = flowerStoreService.assortment(stemSizes);//assortment of bouquets with sizes of stem long
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(expensiveBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByType")
    void rangeByTypeTest() {
        FlowerType[] types = {FlowerType.HYDRANGEA, FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStoreService.assortment(types); //assortment of bouquets with types: HYDRANGEA, PEONY
        Assertions.assertEquals(1, bouquets.size());
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColor")
    void rangeByPriceColorTest() {
        Color[] colors = {Color.PINK};
        Set<Bouquet> bouquets = flowerStoreService.assortment(50, 1500, colors);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(monochromaticBouquet));
        assert (bouquets.contains(hydrangeaBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceType")
    void rangeByPriceTypeTest() {
        FlowerType[] types = {FlowerType.ROSE};
        Set<Bouquet> bouquets = flowerStoreService.assortment(10, 100, types); //assortment of bouquets with price is min 10,  max 100, type: rose
        Assertions.assertNotEquals(1, bouquets.size());
        assert (bouquets.isEmpty());
    }

    @Test
    @DisplayName("assertEquals rangeByColorType")
    void rangeByColorTypeTest() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStoreService.assortment(colors, types); //assortment of bouquets with color: pink, type: peony;
        System.out.println(flowerStoreService.getFlowerStore().getBouquets());
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheapBouquet));
        assert (bouquets.contains(monochromaticBouquet));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColorType")
    void rangeByPriceColorTypeTest() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<Bouquet> bouquets = flowerStoreService.assortment(0, 1300, colors, types, null);
        Assertions.assertEquals(2, bouquets.size());
        assert (bouquets.contains(cheapBouquet));

    }

}
