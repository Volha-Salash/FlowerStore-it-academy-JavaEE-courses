package smallflowerstore.service.interfaces;


import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;

import java.util.Set;

public interface CreatorOfBouquets {


    boolean rangeFlowers(FlowerType[] wantedTypes);

    boolean rangeColors(Color[] wantedColors);

    boolean rangeStemSize(StemSize[] wantedStemSize);

    boolean rangePrice(double minPrice, double maxPrice);

    double price();

    Set<Color> getColors();

    Set<FlowerType> getTypes();

    Set<StemSize> getStemSize();
}
