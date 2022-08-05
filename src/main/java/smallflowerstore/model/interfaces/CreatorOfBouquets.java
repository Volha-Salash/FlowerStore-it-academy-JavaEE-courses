package smallflowerstore.model.interfaces;


import smallflowerstore.model.bouquet.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;

import java.util.Set;

public interface CreatorOfBouquets {

    void addPackaging(Packaging pack);

    Set<Color> getColors();

    Set<FlowerType> getTypes();

    Set<StemSize> getStemSize();

    boolean rangeFlowers(FlowerType[] wantedTypes);

    boolean rangeColors(Color[] wantedColors);

    boolean rangeStemSize(StemSize[] wantedStemSize);

    boolean rangePrice(double minPrice, double maxPrice);

    double price();

}
