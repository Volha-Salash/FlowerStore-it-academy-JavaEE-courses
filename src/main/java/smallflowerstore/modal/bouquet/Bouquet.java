package smallflowerstore.modal.bouquet;

import lombok.Getter;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;
import smallflowerstore.modal.flower.Flower;
import smallflowerstore.modal.flower.Thing;
import smallflowerstore.service.CreatorOfBouquets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


@Getter
public class Bouquet extends Thing implements CreatorOfBouquets {
    private final HashSet<Packaging> packagings;
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
     * <p>
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
    public HashSet<Color> getColors() {
        HashSet<Color> colors = new HashSet<>();
        for (Packaging pack : packagings) {
            colors.add(pack.getColor());
        }
        return colors;
    }

    @Override
    public HashSet<FlowerType> getTypes() {
        HashSet<FlowerType> types = new HashSet<>();
        for (Packaging pack : packagings) {
            types.add(pack.getType());
        }
        return types;
    }

    @Override
    public HashSet<StemSize> getStemSize() {
        HashSet<StemSize> stemSizes = new HashSet<>();
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
        HashSet<FlowerType> repositoryTypes = getTypes();
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
        HashSet<Color> repositoryColors = getColors();
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
        HashSet<StemSize> repositoryStemSize = getStemSize();
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


    @Override
    public List<Flower> getFilteredSteamFlowersList(int minSteamSize, int maxSteamSize) {
        List<Flower> result = new ArrayList<Flower>();
        for (Flower flower : flowers) {
            if (flower.getStemSize() > minSteamSize && flower.getStemSize() < maxSteamSize) {
                result.add(flower);
            }

        }
        return result;
    }

    @Override
    public void getFilterStemSize(Bouquet bouquet) {
        int minStemSize = 35;
        int maxStemSize = 70;
        List<Flower> flowerSteam = bouquet.getFilteredSteamFlowersList(minStemSize, maxStemSize);
        for (int i = 0; i < flowerSteam.size(); i++) {
            System.out.println(flowerSteam.get(i));

        }
    }

    @Override
    public void getFreshFlowers(Bouquet bouquet) {
        List<Flower> flowers = bouquet.getFlowers();
        Collections.sort(flowers);

        for (int i = 0; i < flowers.size(); i++) {
            System.out.print(flowers.get(i) + "\n");
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
