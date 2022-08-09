package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
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
    public Set<BouquetService> assortment(double minPrice, double maxPrice, Color[] colors, FlowerType[] flowers, StemSize[] stemSizes) {
        Set<BouquetService> filterBouquetServices = new HashSet<>();
        for (BouquetService bouquetService : flowerStore.getBouquetServices()) {
            if (bouquetService.rangePrice(minPrice, maxPrice) && bouquetService.rangeColors(colors)
                    && bouquetService.rangeFlowers(flowers) && bouquetService.rangeStemSize(stemSizes)) {
                filterBouquetServices.add(bouquetService);
            }
        }
        return filterBouquetServices;
    }

    public Set<BouquetService> assortment(double minPrice, double maxPrice, Color[] colors) {
        return assortment(minPrice, maxPrice, colors, null, null);
    }

    public Set<BouquetService> assortment(double minPrice, double maxPrice, FlowerType[] types) {
        return assortment(minPrice, maxPrice, null, types, null);
    }

    public Set<BouquetService> assortment(Color[] colors, FlowerType[] types) {
        return assortment(0, Double.MAX_VALUE, colors, types, null);
    }

    public Set<BouquetService> assortment(double minPrice, double maxPrice) {
        return assortment(minPrice, maxPrice, null, null, null);
    }

    public Set<BouquetService> assortment(Color[] colors) {
        return assortment(0, Double.MAX_VALUE, colors, null, null);
    }

    public Set<BouquetService> assortment(StemSize[] stemSizes) {
        return assortment(0, Double.MAX_VALUE, null, null, stemSizes);
    }

    public Set<BouquetService> assortment(FlowerType[] types) {
        return assortment(0, Double.MAX_VALUE, null, types, null);
    }
}
