package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.service.BouquetService;
import smallflowerstore.service.FlowerStoreService;

import java.util.Set;

class FlowerStoreServiceTest {
    FlowerStoreService flowerStoreService;
    BouquetService cheapBouquetService;
    BouquetService expensiveBouquetService;
    BouquetService hudrageaBouquetService;      // with one kind of flowers
    BouquetService monochromaticBouquetService; // with the same color

    @BeforeEach
    void setUp() {
        flowerStoreService = new FlowerStoreService();

        cheapBouquetService = new BouquetService();
        expensiveBouquetService = new BouquetService();
        hudrageaBouquetService = new BouquetService();
        monochromaticBouquetService = new BouquetService();

        Flower whiteRose = new Flower(FlowerType.ROSE, Color.WHITE, 12.0, StemSize.LONG, true);
        Flower redRose = new Flower(FlowerType.ROSE, Color.RED, 12.0, StemSize.LONG, true);
        Flower pinkPeony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        Flower pinkHydragea = new Flower(FlowerType.HYDRANGEA, Color.PINK, 18.0, StemSize.MIDDLE, true);

        cheapBouquetService.addPackaging(new Packaging(pinkPeony, 3)); // price 7.30 * 3 = 21.9
        expensiveBouquetService.addPackaging(new Packaging(redRose, 70)); // price 12.00 * 70 + 12.0 * 31 = 1212.0
        expensiveBouquetService.addPackaging(new Packaging(whiteRose, 31));
        hudrageaBouquetService.addPackaging(new Packaging(pinkHydragea, 5)); // price 18.0 * 5 = 90.0
        monochromaticBouquetService.addPackaging(new Packaging(pinkPeony, 5)); // price 7.30 * 5 + 18.0 * 6 = 144.5
        monochromaticBouquetService.addPackaging(new Packaging(pinkHydragea, 6));

        flowerStoreService.addBouquet(monochromaticBouquetService);
        flowerStoreService.addBouquet(expensiveBouquetService);
        flowerStoreService.addBouquet(cheapBouquetService);
        flowerStoreService.addBouquet(hudrageaBouquetService);
    }

    @Test
    @DisplayName("assertEquals addBouquet")
    void addBouquetTest() {
        BouquetService new_bouquetService = new BouquetService();

        Set<BouquetService> bouquetServices = flowerStoreService.getBouquetServices();
        Assertions.assertEquals(4, bouquetServices.size());
        assert (!bouquetServices.contains(new_bouquetService));

        flowerStoreService.addBouquet(new_bouquetService);
        bouquetServices = flowerStoreService.getBouquetServices();
        Assertions.assertEquals(5, bouquetServices.size());
        assert (bouquetServices.contains(new_bouquetService));

        flowerStoreService.addBouquet(new_bouquetService);
        bouquetServices = flowerStoreService.getBouquetServices();
        Assertions.assertEquals(5, bouquetServices.size());
    }

    @Test
    @DisplayName("assertEquals rangeByPrice")
    void rangeByPriceTest() {
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(20, 150); // assortment of bouquets with price [20, 150]
        Assertions.assertEquals(3, bouquetServices.size());
        assert (bouquetServices.contains(cheapBouquetService));
        assert (bouquetServices.contains(monochromaticBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByColor")
    void rangeByColorTest() {
        Color[] colors = {Color.WHITE, Color.RED};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(colors); //assortment of bouquets with color white, red
        Assertions.assertEquals(1, bouquetServices.size());
        assert (bouquetServices.contains(expensiveBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByStemSize")
    void rangeStemSizeTest() {
        StemSize[] stemSizes = {StemSize.LONG};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(stemSizes); //assortment of bouquets with sizes of stem long
        Assertions.assertEquals(1, bouquetServices.size());
        assert (bouquetServices.contains(expensiveBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByType")
    void rangeByTypeTest() {
        FlowerType[] types = {FlowerType.HYDRANGEA, FlowerType.PEONY};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(types); //assortment of bouquets with types: HYDRANGEA, PEONY
        Assertions.assertEquals(1, bouquetServices.size());
        assert (bouquetServices.contains(monochromaticBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColor")
    void rangeByPriceColorTest() {
        Color[] colors = {Color.PINK};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(50, 1500, colors);
        Assertions.assertEquals(2, bouquetServices.size());
        assert (bouquetServices.contains(monochromaticBouquetService));
        assert (bouquetServices.contains(hudrageaBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceType")
    void rangeByPriceTypeTest() {
        FlowerType[] types = {FlowerType.ROSE};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(10, 100, types); //assortment of bouquets with price is min 10,  max 100, type: rose
        Assertions.assertNotEquals(1, bouquetServices.size());
        assert (bouquetServices.isEmpty());
    }

    @Test
    @DisplayName("assertEquals rangeByColorType")
    void rangeByColorTypeTest() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(colors, types); //assortment of bouquets with color: pink, type: peony;
        Assertions.assertEquals(2, bouquetServices.size());
        assert (bouquetServices.contains(cheapBouquetService));
        assert (bouquetServices.contains(monochromaticBouquetService));
    }

    @Test
    @DisplayName("assertEquals rangeByPriceColorType")
    void rangeByPriceColorTypeTest() {
        Color[] colors = {Color.PINK};
        FlowerType[] types = {FlowerType.PEONY};
        Set<BouquetService> bouquetServices = flowerStoreService.assortment(0, 1300, colors, types, null);
        Assertions.assertEquals(2, bouquetServices.size());
        assert (bouquetServices.contains(cheapBouquetService));

    }

}
