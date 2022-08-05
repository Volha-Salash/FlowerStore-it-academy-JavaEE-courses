package smallflowerstore.model.interfaces;

import smallflowerstore.model.ProductFlowersStore;

public interface Price {

    double calculateTotalPrice();

    void addProductFlowersStore(ProductFlowersStore productFlowersStore);

    void removeProductFlowersStore(ProductFlowersStore productFlowersStore);

}
