package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.shop.Bouquet;
import smallflowerstore.model.shop.FlowerStore;

import java.util.HashSet;
import java.util.Set;

/**
 * Flower`s store
 */

@Getter
@Setter
public class FlowerStoreService {
    private FlowerStore flowerStore = new FlowerStore();

    /**
     * Search bouquets by specified criteria
     *
     * @param minPrice  - minimal price of bouquet
     * @param maxPrice  - maximum price of bouquet
     * @param colors    - colors which must be in bouquet
     * @param flowers   - types of flower which must be in bouquet
     * @param stemSizes - size of flowers stem which must be in bouquet
     * @return HashSet of bouquets that meet the criteria
     */
    @NotNull
    public Set<Bouquet> assortment(double minPrice, double maxPrice, Color[] colors, FlowerType[] flowers, StemSize[] stemSizes) {
        Set<Bouquet> filterBouquetServices = new HashSet<>();
        BouquetService bouquetService = new BouquetService();
        for (Bouquet bouquet : flowerStore.getBouquets()) {
            if (bouquetService.rangePrice(minPrice, maxPrice, bouquet) && bouquetService.rangeColors(colors, bouquet)
                    && bouquetService.rangeFlowers(flowers, bouquet) && bouquetService.rangeStemSize(stemSizes, bouquet)) {
                filterBouquetServices.add(bouquet);
            }
        }
        return filterBouquetServices;
    }

    @NotNull
    public Set<Bouquet> assortment(double minPrice, double maxPrice, Color[] colors) {
        return assortment(minPrice, maxPrice, colors, null, null);
    }

    @NotNull
    public Set<Bouquet> assortment(double minPrice, double maxPrice, FlowerType[] types) {
        return assortment(minPrice, maxPrice, null, types, null);
    }

    @NotNull
    public Set<Bouquet> assortment(Color[] colors, FlowerType[] types) {
        return assortment(0, Double.MAX_VALUE, colors, types, null);
    }

    @NotNull
    public Set<Bouquet> assortment(double minPrice, double maxPrice) {
        return assortment(minPrice, maxPrice, null, null, null);
    }

    @NotNull
    public Set<Bouquet> assortment(Color[] colors) {
        return assortment(0, Double.MAX_VALUE, colors, null, null);
    }

    @NotNull
    public Set<Bouquet> assortment(StemSize[] stemSizes) {
        return assortment(0, Double.MAX_VALUE, null, null, stemSizes);
    }

    @NotNull
    public Set<Bouquet> assortment(FlowerType[] types) {
        return assortment(0, Double.MAX_VALUE, null, types, null);
    }

    public FlowerStore getFlowerStore() {
        return flowerStore;
    }
}
