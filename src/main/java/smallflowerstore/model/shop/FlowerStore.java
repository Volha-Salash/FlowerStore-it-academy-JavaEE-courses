package smallflowerstore.model.shop;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class FlowerStore {
    @NotNull
    private final Set<Bouquet> bouquets;

    public FlowerStore() {
        bouquets = new HashSet<>();
    }

    public @NotNull Set<Bouquet> getBouquets() {
        return bouquets;
    }

    public void addBouquet(Bouquet bouquet) {
        bouquets.add(bouquet);
    }
}
