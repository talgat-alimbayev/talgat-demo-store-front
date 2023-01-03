package talgat.demo.store.front.model;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Cart {
    @Size(min=1, message = "Для перехода на кассу нужно добавить хотя бы один продукт из списка")
    private List<Item> itemList = new ArrayList<>();
    private BigDecimal total;

    public void calculateTotal(){
        total = new BigDecimal(0);
        for (Item item: itemList){
            total = total.add(item.getPrice());
        }
    }

    public void addItem(Item item){
        itemList.add(item);
    }

    public Set<Long> getItemIds(){
        return itemList.stream().map(item -> item.getId()).collect(Collectors.toSet());
    }


}
