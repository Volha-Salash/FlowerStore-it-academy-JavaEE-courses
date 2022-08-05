package testFlowerStore.bouquet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smallflowerstore.modal.bouquet.Bouquet;
import smallflowerstore.modal.bouquet.Packaging;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;
import smallflowerstore.modal.flower.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class BouquetTest {
    Bouquet bouquet;
    Packaging peony_pack, hudrangea_pack, rose_pack;
    private List<flowerstore.modal.flower.Flower> flowers = new ArrayList<flowerstore.modal.flower.Flower>();

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
        Flower peony = new Flower(FlowerType.PEONY, Color.PINK, 7.30, StemSize.MIDDLE, true);
        peony_pack = new Packaging(peony, 9);
        bouquet.addPackaging(peony_pack);

        Flower hudrangea = new Flower(FlowerType.HYDRANGEA, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        hudrangea_pack = new Packaging(hudrangea, 9);
        bouquet.addPackaging(hudrangea_pack);


        Flower rose = new Flower(FlowerType.ROSE, Color.BLUE, 15.0, StemSize.MIDDLE, true);
        rose_pack = new Packaging(rose, 20);
    }

    @Test
    void addPackaging() {
        HashSet<Packaging> packs = bouquet.getPackagings();
        assert (!packs.isEmpty());
        assert (packs.contains(peony_pack));
        assert (packs.contains(hudrangea_pack));
        assert (!packs.contains(rose_pack));

        bouquet.addPackaging(rose_pack);
        assert (packs.contains(rose_pack));
    }

    @Test
    void getPrice() {
        Assertions.assertEquals(200.7, bouquet.price());
        bouquet.addPackaging(rose_pack);
        Assertions.assertEquals(500.7, bouquet.price());
    }

    @Test
    void getColors() {
        HashSet<Color> colors = bouquet.getColors();
        assert (colors.contains(Color.PINK));
        assert (colors.contains(Color.PINK));
        assert (!colors.contains(Color.WHITE));

        bouquet.addPackaging(peony_pack);
        colors = bouquet.getColors();
        assert (colors.contains(Color.PINK));
    }

    @Test
    void getTypes() {
        HashSet<FlowerType> types = bouquet.getTypes();
        assert (types.contains(FlowerType.PEONY));
        assert (types.contains(FlowerType.HYDRANGEA));
        assert (!types.contains(FlowerType.ROSE));

        bouquet.addPackaging(rose_pack);
        types = bouquet.getTypes();
        assert (types.contains(FlowerType.ROSE));
    }


    @Test
    void getFilterStemSize() {
        Assertions.assertNotEquals(StemSize.MIDDLE, bouquet.getStemSize());
        bouquet.addPackaging(peony_pack);
        Assertions.assertNotEquals(StemSize.LONG, bouquet.getStemSize());
    }

    @Test
    void getFreshFlowers() {
        Collections.sort(flowers);
        for (int i = 0; i < flowers.size(); i++) {
            boolean expected = true;
            Assertions.assertTrue(true, (Supplier<String>) flowers.get(i));
        }
    }
}



