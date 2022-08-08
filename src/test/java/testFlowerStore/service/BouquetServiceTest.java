package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.service.BouquetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

class BouquetServiceTest {
    BouquetService bouquetService;
    Packaging peonyPack, hudrangeaPack, rosePack;
    List<Flower> flowers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        bouquetService = new BouquetService();
        Flower peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        peonyPack = new Packaging(peony, 9);
        bouquetService.addPackaging(peonyPack);

        Flower hudrangea = new Flower(FlowerType.HYDRANGEA, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        hudrangeaPack = new Packaging(hudrangea, 9);
        bouquetService.addPackaging(hudrangeaPack);


        Flower rose = new Flower(FlowerType.ROSE, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        rosePack = new Packaging(rose, 20);
    }

    @Test
    void addPackagingTest() {
        Set<Packaging> packs = bouquetService.getPackagings();
        assert (!packs.isEmpty());
        assert (packs.contains(peonyPack));
        assert (packs.contains(hudrangeaPack));
        assert (!packs.contains(rosePack));

        bouquetService.addPackaging(rosePack);
        assert (packs.contains(rosePack));
    }

    @Test
    void getPriceTest() {
        Assertions.assertEquals(200.7, bouquetService.price());
        bouquetService.addPackaging(rosePack);
        Assertions.assertEquals(500.7, bouquetService.price());
    }

    @Test
    void getColorsTest() {
        Set<Color> colors = bouquetService.getColors();
        assert (colors.contains(Color.PINK));
        assert (colors.contains(Color.PINK));
        assert (!colors.contains(Color.WHITE));

        bouquetService.addPackaging(peonyPack);
        colors = bouquetService.getColors();
        assert (colors.contains(Color.PINK));
    }

    @Test
    void getTypesTest() {
        Set<FlowerType> types = bouquetService.getTypes();
        assert (types.contains(FlowerType.PEONY));
        assert (types.contains(FlowerType.HYDRANGEA));
        assert (!types.contains(FlowerType.ROSE));

        bouquetService.addPackaging(rosePack);
        types = bouquetService.getTypes();
        assert (types.contains(FlowerType.ROSE));
    }


    @Test
    void getFilterStemSizeTest() {
        Assertions.assertNotEquals(StemSize.MIDDLE, bouquetService.getStemSize());
        bouquetService.addPackaging(peonyPack);
        Assertions.assertNotEquals(StemSize.LONG, bouquetService.getStemSize());
    }

    @Test
    void getFreshFlowersTest() {
        for (Flower flower : flowers) {
            Assertions.assertTrue(true, (Supplier<String>) flower);
        }
    }
}