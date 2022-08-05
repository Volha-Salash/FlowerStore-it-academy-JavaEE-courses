package smallflowerstore.model.pack;

import smallflowerstore.model.ProductFlowersStore;

public abstract class Accessories extends ProductFlowersStore {
    private final ProductFlowersStore productFlowersStore;

    public Accessories(ProductFlowersStore productFlowersStore) {
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
