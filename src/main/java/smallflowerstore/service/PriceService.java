package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.shop.Price;
import smallflowerstore.service.interfaces.Cost;

@Getter
@Setter
public class PriceService extends Price implements Cost {

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (ProductFlowersStore orderProductFlowersStore : getProductFlowersStores()) {
            totalPrice += orderProductFlowersStore.price();
        }
        return totalPrice;
    }

}

