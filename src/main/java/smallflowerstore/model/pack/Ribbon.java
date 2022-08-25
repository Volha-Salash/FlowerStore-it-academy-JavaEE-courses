package smallflowerstore.model.pack;

import smallflowerstore.model.ProductFlowersStore;

public class Ribbon extends Accessories {
    private static final double priceRibbon = 5;

    public Ribbon(ProductFlowersStore productFlowersStore) {
        super(productFlowersStore);
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " with ribbon";
    }

    @Override
    public double price() {
        return priceRibbon;
    }
}
