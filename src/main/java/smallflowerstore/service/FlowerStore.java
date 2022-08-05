package smallflowerstore.service;
import lombok.Getter;
import lombok.Setter;
import smallflowerstore.modal.bouquet.Bouquet;
import smallflowerstore.modal.enums.Color;
import smallflowerstore.modal.enums.FlowerType;
import smallflowerstore.modal.enums.StemSize;

import java.util.HashSet;

/**
 * Flower`s store
 */

@Getter @Setter
public class FlowerStore {
    HashSet<Bouquet> bouquets;

    /**
     * Create new empty flower`s store
     */
    public FlowerStore (){
        bouquets = new HashSet<>();
    }

    /**
     * Add new bouquet to Flower`s Store
     * @param bouquet - new bouquet
     */
    public void addBouquet(Bouquet bouquet){
        bouquets.add(bouquet);
    }

    /**
     * Search bouquets by specified criteria
     * @param minPrice - minimal price of bouquet
     * @param maxPrice - maximum price of bouquet
     * @param colors - colors which must be in bouquet
     * @param flowers - types of flower which must be in bouquet
     * @param stemSizes - size of flowers stem which must be in bouquet
     * @return HashSet of bouquets that meet the criteria
     */
    public HashSet<Bouquet> assortment(double minPrice, double maxPrice, Color[] colors, FlowerType[] flowers, StemSize [] stemSizes){
        HashSet<Bouquet> filterBouquets = new HashSet<>();
        for (Bouquet bouquet : bouquets) {
            if (bouquet.rangePrice(minPrice, maxPrice) && bouquet.rangeColors(colors)
                    && bouquet.rangeFlowers(flowers) && bouquet.rangeStemSize(stemSizes)){
                filterBouquets.add(bouquet);
            }
        }
        return filterBouquets;
    }

    public HashSet<Bouquet> assortment (double minPrice, double maxPrice, Color[] colors){
        return assortment (minPrice, maxPrice, colors, null, null);
    }

    public HashSet<Bouquet> assortment (double minPrice, double maxPrice, FlowerType[] types){
        return assortment (minPrice, maxPrice, null, types,null);
    }

    public HashSet<Bouquet> assortment (Color[] colors, FlowerType[] types){
        return assortment (0, Double.MAX_VALUE, colors, types, null);
    }

    public HashSet<Bouquet> assortment (double minPrice, double maxPrice){
        return assortment (minPrice, maxPrice, null, null,null);
    }

    public HashSet<Bouquet> assortment (Color[] colors){
        return assortment (0, Double.MAX_VALUE, colors, null,null);
    }

    public HashSet<Bouquet> assortment (StemSize[] stemSizes){
        return assortment (0, Double.MAX_VALUE, null, null, stemSizes);
    }

    public HashSet<Bouquet> assortment (FlowerType[] types){
        return assortment (0, Double.MAX_VALUE, null, types, null);
    }
}
