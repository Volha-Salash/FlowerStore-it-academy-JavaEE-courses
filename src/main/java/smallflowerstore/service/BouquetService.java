package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.model.shop.Bouquet;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.service.interfaces.CreatorOfBouquets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static smallflowerstore.model.enums.StemSize.*;


@Getter
@Setter
public class BouquetService extends Bouquet implements CreatorOfBouquets {
    /**
     * Verify if Bouquet has flowers of all needed types
     *
     * @param wantedTypes - list of wanted types
     * @return true is satisfies criteria, false otherwise
     */

    @Override
    public boolean rangeFlowers(FlowerType[] wantedTypes) {
        Set<FlowerType> repositoryTypes = getTypes();
        if (wantedTypes == null) {
            return true;
        }
        for (FlowerType type : wantedTypes) {
            if (!repositoryTypes.contains(type)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verify if Bouquet has flowers of all needed colors
     *
     * @param wantedColors - list of wanted colors
     * @return true is satisfies criteria, false otherwise
     */

    @Override
    public boolean rangeColors(Color[] wantedColors) {
        Set<Color> repositoryColors = getColors();
        if (wantedColors == null) {
            return true;
        }
        for (Color color : wantedColors) {
            if (!repositoryColors.contains(color)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sort flowers by lenght/Size
     *
     * @param wantedStemSize - list of wanted Size of stem
     * @return true is satisfies criteria, false otherwise
     */
    @Override
    public boolean rangeStemSize(StemSize[] wantedStemSize) {
        Set<StemSize> repositoryStemSize = getStemSize();
        if (wantedStemSize == null) {
            return true;
        }
        for (StemSize stemSize : wantedStemSize) {
            if (!repositoryStemSize.contains(stemSize)) {
                return false;
            }
        }
        return true;
    }


    public List<Flower> getFilteredSteamFlowersList(StemSize SHORT, StemSize LONG) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : getFlowers()) {
            if (flower.getStemSize() == SHORT || flower.getStemSize() == MIDDLE || flower.getStemSize() == LONG) {
                result.add(flower);
            }

        }
        return result;
    }


    public void getFilterSteamSize(BouquetService bouquetService) {
        List<Flower> flowerSteam = bouquetService.getFilteredSteamFlowersList(SHORT, LONG);
        for (Flower flower : flowerSteam) {
            System.out.println(flower);

        }
    }

    /**
     * Verify if Bouquet in specified range
     *
     * @param minPrice - minimal price of Bouquet
     * @param maxPrice - maximum price of Bouquet
     * @return true is satisfies criteria, false otherwise
     */
    @Override
    public boolean rangePrice(double minPrice, double maxPrice) {
        double price = price();
        return minPrice <= price && price <= maxPrice;
    }

    @Override
    public double price() {
        double price = 0.0;
        for (Packaging pack : getPackagings()) {
            price += pack.getPrice();
        }
        return price;
    }

}
