package smallflowerstore.service.interfaces;


import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.shop.Bouquet;

import java.util.Set;

public interface CreatorOfBouquets {


    boolean rangeFlowers(FlowerType[] wantedTypes, Bouquet bouquet);

    boolean rangeColors(Color[] wantedColors, Bouquet bouquet);

    boolean rangeStemSize(StemSize[] wantedStemSize, Bouquet bouquet);

    boolean rangePrice(double minPrice, double maxPrice, Bouquet bouquet);

    double price(Bouquet bouquet);

    Set<Color> getColors(Bouquet bouquet);

    Set<FlowerType> getTypes(Bouquet bouquet);

    Set<StemSize> getStemSize(Bouquet bouquet);
}
