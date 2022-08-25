package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;
import smallflowerstore.model.shop.Bouquet;
import smallflowerstore.model.shop.Packaging;
import smallflowerstore.service.interfaces.CreatorOfBouquets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;
import static smallflowerstore.model.enums.StemSize.*;


@Getter
@Setter
public class BouquetService implements CreatorOfBouquets {

    /**
     * Verify if Bouquet has flowers of all needed types
     *
     * @param wantedTypes - list of wanted types
     * @return true is satisfies criteria, false otherwise
     */

    @Override
    public boolean rangeFlowers(FlowerType[] wantedTypes, Bouquet bouquet) {
        Set<FlowerType> repositoryTypes = getTypes(bouquet);
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
    public boolean rangeColors(Color[] wantedColors, Bouquet bouquet) {
        Set<Color> repositoryColors = getColors(bouquet);
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
    public boolean rangeStemSize(StemSize[] wantedStemSize, Bouquet bouquet) {
        Set<StemSize> repositoryStemSize = getStemSize(bouquet);
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


    public List<Flower> getFilteredSteamFlowersList(Bouquet bouquet) {
        List<Flower> result = new ArrayList<>();
        for (Flower flower : bouquet.getFlowers()) {
            if (flower.getStemSize() == SHORT || flower.getStemSize() == MIDDLE || flower.getStemSize() == LONG) {
                result.add(flower);
            }

        }
        return result;
    }


    public void getFilterSteamSize(Bouquet bouquet) {
        List<Flower> flowerSteam = getFilteredSteamFlowersList(bouquet);
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
    public boolean rangePrice(double minPrice, double maxPrice, Bouquet bouquet) {
        double price = price(bouquet);
        return minPrice <= price && price <= maxPrice;
    }

    @Override
    public double price(Bouquet bouquet) {
        double price = 0.0;
        for (Packaging pack : bouquet.getPackagings()) {
            price += pack.getPrice();
        }
        return price;
    }

    @Override
    public Set<Color> getColors(Bouquet bouquet) {
        Set<Color> colors = new HashSet<>();
        for (Packaging pack : bouquet.getPackagings()) {
            colors.add(pack.getColor());
        }
        return colors;
    }

    @Override
    @NotNull
    public Set<FlowerType> getTypes(Bouquet bouquet) {
        Set<FlowerType> types = new HashSet<>();
        for (Packaging pack : bouquet.getPackagings()) {
            types.add(pack.getType());
        }
        return types;
    }

    @NotNull
    @Override
    public Set<StemSize> getStemSize(Bouquet bouquet) {
        Set<StemSize> stemSizes = new HashSet<>();
        for (Packaging flower : bouquet.getPackagings()) {
            stemSizes.add(flower.getStemSize());
        }
        return stemSizes;
    }
}
