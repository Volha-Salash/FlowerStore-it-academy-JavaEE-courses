package smallflowerstore.model.pack;

import smallflowerstore.model.ProductFlowersStore;

public class DecorativePaper extends Accessories {
    private static final double price = 7;

    public DecorativePaper(ProductFlowersStore productFlowersStore) {
        super(productFlowersStore);
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " in decorative paper";
    }
}
