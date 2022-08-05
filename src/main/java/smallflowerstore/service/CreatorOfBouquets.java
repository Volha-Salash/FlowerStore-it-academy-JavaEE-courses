package smallflowerstore.service;

import flowerstore.modal.flower.Flower;
import smallflowerstore.modal.bouquet.Bouquet;
import smallflowerstore.modal.bouquet.Packaging;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;

import java.util.HashSet;
import java.util.List;

public interface CreatorOfBouquets {

    void addPackaging(Packaging pack);

    HashSet<Color> getColors();

    HashSet<FlowerType> getTypes();

    HashSet<StemSize> getStemSize();

    boolean rangeFlowers(FlowerType[] wantedTypes);

    boolean rangeColors(Color[] wantedColors);

    boolean rangeStemSize(StemSize[] wantedStemSize);

    void getFilterStemSize(Bouquet bouquet);

    void getFreshFlowers(Bouquet bouquet);

    List<Flower> getFilteredSteamFlowersList(int minSteamSize, int maxSteamSize);

    boolean rangePrice(double minPrice, double maxPrice);

    double price();

}
