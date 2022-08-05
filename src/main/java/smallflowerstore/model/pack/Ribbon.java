package smallflowerstore.model.pack;

import smallflowerstore.model.ProductFlowersStore;

public class Ribbon extends Accessories {
    public Ribbon(ProductFlowersStore productFlowersStore) {
        super(productFlowersStore);
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " with ribbon";
    }

    @Override
    public double price() {
        return super.price() + 5;
    }
}
