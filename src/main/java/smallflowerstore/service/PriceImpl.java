package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.interfaces.Price;
import smallflowerstore.model.ProductFlowersStore;

import java.util.LinkedList;
import java.util.Set;

@Getter
@Setter
public class PriceImpl implements Price {

    private final Set<ProductFlowersStore> productFlowersStores;

    public PriceImpl() {
        this.productFlowersStores = (Set<ProductFlowersStore>) new LinkedList();
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (ProductFlowersStore orderProductFlowersStore : productFlowersStores) {
            totalPrice += orderProductFlowersStore.price();
        }
        return totalPrice;
    }

    @Override
    public void addProductFlowersStore(ProductFlowersStore productFlowersStore) {
        productFlowersStores.add(productFlowersStore);
    }

    @Override
    public void removeProductFlowersStore(ProductFlowersStore productFlowersStore) {
        productFlowersStores.remove(productFlowersStore);
    }

}

