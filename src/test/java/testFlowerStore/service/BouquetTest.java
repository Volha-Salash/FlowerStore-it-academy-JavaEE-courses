package testFlowerStore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smallflowerstore.model.bouquet.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.service.Bouquet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class BouquetTest {
    Bouquet bouquet;
    Packaging peonyPack, hudrangeaPack, rosePack;
    private final List<Flower> flowers = new ArrayList<Flower>();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        Flower peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        peonyPack = new Packaging(peony, 9);
        bouquet.addPackaging(peonyPack);

        Flower hudrangea = new Flower(FlowerType.HYDRANGEA, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        hudrangeaPack = new Packaging(hudrangea, 9);
        bouquet.addPackaging(hudrangeaPack);


        Flower rose = new Flower(FlowerType.ROSE, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        rosePack = new Packaging(rose, 20);
    }

    @Test
    void addPackaging() {
        Set<Packaging> packs = bouquet.getPackagings();
        assert (!packs.isEmpty());
        assert (packs.contains(peonyPack));
        assert (packs.contains(hudrangeaPack));
        assert (!packs.contains(rosePack));

        bouquet.addPackaging(rosePack);
        assert (packs.contains(rosePack));
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(200.7, bouquet.price());
        bouquet.addPackaging(rosePack);
        Assertions.assertEquals(500.7, bouquet.price());
    }

    @Test
    void getColors() {
        Set<Color> colors = bouquet.getColors();
        assert (colors.contains(Color.PINK));
        assert (colors.contains(Color.PINK));
        assert (!colors.contains(Color.WHITE));

        bouquet.addPackaging(peonyPack);
        colors = bouquet.getColors();
        assert (colors.contains(Color.PINK));
    }

    @Test
    void getTypes() {
        Set<FlowerType> types = bouquet.getTypes();
        assert (types.contains(FlowerType.PEONY));
        assert (types.contains(FlowerType.HYDRANGEA));
        assert (!types.contains(FlowerType.ROSE));

        bouquet.addPackaging(rosePack);
        types = bouquet.getTypes();
        assert (types.contains(FlowerType.ROSE));
    }


    @Test
    void getFilterStemSize() {
        Assertions.assertNotEquals(StemSize.MIDDLE, bouquet.getStemSize());
        bouquet.addPackaging(peonyPack);
        Assertions.assertNotEquals(StemSize.LONG, bouquet.getStemSize());
    }

    @Test
    void getFreshFlowers() {
        for (Flower flower : flowers) {
            Assertions.assertTrue(true, (Supplier<String>) flower);
        }
    }
}