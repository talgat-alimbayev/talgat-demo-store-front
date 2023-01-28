package talgat.demo.store.front.model;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    @Size(min=1, message = "Для перехода на кассу нужно добавить хотя бы один продукт из списка")
    private List<ItemStore> items = new ArrayList<>();
    private BigDecimal total;

    public void calculateTotal(){
        total = new BigDecimal(0);
        for (ItemStore item: items){
            total = total.add(item.getPrice());
        }
    }

    public void addItem(ItemStore item){
        items.add(item);
    }

//    public Set<Long> getItemIds(){
//        return itemList.stream().map(item -> item.getId()).collect(Collectors.toSet());
//    }


}
