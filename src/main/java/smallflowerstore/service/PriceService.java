package smallflowerstore.service;

import lombok.Getter;
import lombok.Setter;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.shop.Price;
import smallflowerstore.service.interfaces.Cost;

@Getter
@Setter
public class PriceService implements Cost {
    private Price price = new Price();

    @Override
    public double calculateTotalPrice(ProductFlowersStore productFlowersStore) {
        double totalPrice = 0.0;
        for (ProductFlowersStore orderProductFlowersStore : price.getProductFlowersStores()) {
            totalPrice += orderProductFlowersStore.price();
        }
        return totalPrice;
    }

    public Price getPrice() {
        return price;
    }
}

