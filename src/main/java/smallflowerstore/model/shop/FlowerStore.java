package smallflowerstore.model.shop;

import org.jetbrains.annotations.NotNull;
import smallflowerstore.service.BouquetService;

import java.util.HashSet;
import java.util.Set;

public class FlowerStore {
    @NotNull
    private final Set<BouquetService> bouquetServices;

    public FlowerStore() {
        bouquetServices = new HashSet<>();
    }

    public @NotNull Set<BouquetService> getBouquetServices() {
        return bouquetServices;
    }

    public void addBouquet(BouquetService bouquetService) {
        bouquetServices.add(bouquetService);
    }
}
