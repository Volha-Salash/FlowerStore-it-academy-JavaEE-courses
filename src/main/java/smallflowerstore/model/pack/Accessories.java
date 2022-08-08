package smallflowerstore.model.pack;

import org.jetbrains.annotations.NotNull;
import smallflowerstore.model.ProductFlowersStore;

public abstract class Accessories extends ProductFlowersStore {
    @NotNull
    private final ProductFlowersStore productFlowersStore;

    protected Accessories(@NotNull ProductFlowersStore productFlowersStore) {
        this.productFlowersStore = productFlowersStore;
    }

    @Override
    public String getTitle() {
        return productFlowersStore.getTitle();
    }

    @Override
    public double price() {
        return productFlowersStore.price();
    }

}
