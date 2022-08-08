package smallflowerstore.model.shop;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import smallflowerstore.model.ProductFlowersStore;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Price {
    @NotNull
    private Set<ProductFlowersStore> productFlowersStores;

    public Price() {
        this.productFlowersStores = new HashSet<>();
    }

    public @NotNull Set<ProductFlowersStore> getProductFlowersStores() {
        return productFlowersStores;
    }

    public void addProductFlowersStore(ProductFlowersStore productFlowersStore) {
        getProductFlowersStores().add(productFlowersStore);
    }

    public void removeProductFlowersStore(ProductFlowersStore productFlowersStore) {
        getProductFlowersStores().remove(productFlowersStore);
    }
}
