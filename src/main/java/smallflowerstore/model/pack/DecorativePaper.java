package smallflowerstore.model.pack;

import smallflowerstore.model.ProductFlowersStore;

public class DecorativePaper extends Accessories {

    public DecorativePaper(ProductFlowersStore productFlowersStore) {
        super(productFlowersStore);
    }

    @Override
    public double price() {
        return super.price() + 7;
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " in decorative paper";
    }
}
