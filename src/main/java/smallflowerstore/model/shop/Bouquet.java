package smallflowerstore.model.shop;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import smallflowerstore.model.ProductFlowersStore;
import smallflowerstore.model.enums.Color;
import smallflowerstore.model.enums.FlowerType;
import smallflowerstore.model.enums.StemSize;
import smallflowerstore.model.flower.Flower;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Bouquet extends ProductFlowersStore {
    @NotNull
    private final Set<Packaging> packagings;
    @NotNull
    private final List<Flower> flowers = new ArrayList<>();

    public Bouquet() {
        super();
        this.packagings = new HashSet<>();
        changeTitle();
    }


    public Set<Packaging> getPackagings() {
        return packagings;
    }


    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addPackaging(Packaging pack) {
        packagings.add(pack);
        changeTitle();
    }

    public Set<Color> getColors() {
        Set<Color> colors = new HashSet<>();
        for (Packaging pack : getPackagings()) {
            colors.add(pack.getColor());
        }
        return colors;
    }


    public Set<FlowerType> getTypes() {
        Set<FlowerType> types = new HashSet<>();
        for (Packaging pack : getPackagings()) {
            types.add(pack.getType());
        }
        return types;
    }


    public Set<StemSize> getStemSize() {
        Set<StemSize> stemSizes = new HashSet<>();
        for (Packaging flower : getPackagings()) {
            stemSizes.add(flower.getStemSize());
        }
        return stemSizes;
    }


    @Override
    public String toString() {
        String title = "Bouquet of flower`s ";
        if (getPackagings() == null || getPackagings().isEmpty()) {
            title += "without flowers";
        } else {
            String packs = getPackagings().toString();
            packs = packs.substring(1, packs.length() - 1);
            title += packs;
        }
        return title;
    }

}
