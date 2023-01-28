package talgat.demo.store.front.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
public class ItemOrder {
    private String name;
    private BigDecimal price;

    public ItemOrder(ItemStore itemStore){
        this.name = itemStore.getName();
        this.price = itemStore.getPrice();
    }
}
