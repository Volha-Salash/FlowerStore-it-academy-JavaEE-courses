package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.interfaces.CreatorOfBouquets;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.bouquet.Packaging;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static smallflowerstore.model.enums.StemSize.*;


@Getter
@Setter
public class Bouquet extends ProductFlowersStore implements CreatorOfBouquets {
    private final Set<Packaging> packagings;
    private List<Flower> flowers = new ArrayList<Flower>();

    /**
     * Create new Bouquet
     */
    public Bouquet() {
        super();
        this.packagings = new HashSet<>();
        changeTitle();
    }

    /**
     * Bouquet
     * Add new flower`s to pack
     *
     * @param pack - new flower`s pack
     */

    @Override
    public void addPackaging(Packaging pack) {
        packagings.add(pack);
        changeTitle();
    }

    @Override
    public Set<Color> getColors() {
        Set<Color> colors = new HashSet<>();
        for (Packaging pack : packagings) {
            colors.add(pack.getColor());
        }
        return colors;
    }

    @Override
    public Set<FlowerType> getTypes() {
        Set<FlowerType> types = new HashSet<>();
        for (Packaging pack : packagings) {
            types.add(pack.getType());
        }
        return types;
    }

    @Override
    public Set<StemSize> getStemSize() {
        Set<StemSize> stemSizes = new HashSet<>();
        for (Packaging flower : packagings) {
            stemSizes.add(flower.getStemSize());
        }
        return stemSizes;
    }

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
     * @param - list of wanted Size of stem
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


    public List<Flower> getFilteredSteamFlowersList(StemSize min, StemSize max) {
        List<Flower> result = new ArrayList<Flower>();
        for (Flower flower : flowers) {
            if (flower.getStemSize() == SHORT || flower.getStemSize() == MIDDLE || flower.getStemSize() == LONG) {
                result.add(flower);
            }

        }
        return result;
    }


    public void getFilterSteamSize(Bouquet bouquet) {
        List<Flower> flowerSteam = bouquet.getFilteredSteamFlowersList(SHORT, LONG); // minStemSize = SHORT = 35sm; maxStemSize = LONG = 70sm;
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
        for (Packaging pack : packagings) {
            price += pack.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        String title = "Bouquet of flower`s ";
        if (packagings == null || packagings.isEmpty()) {
            title += "without flowers";
        } else {
            String packs = getPackagings().toString();
            packs = packs.substring(1, packs.length() - 1);
            title += packs;
        }
        return title;
    }

}
