package talgat.demo.store.front.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Order {
    private Long id;
    @NotBlank(message = "Не забудьте адрес доставки")
    private String deliveryAddress;
    @Size(min=1, message = "Для перехода на кассу нужно добавить хотя бы один продукт из списка")
    private Set<Long> itemIds = new HashSet<>();
//    private String comment;
//    public void addItem(Item item){
//        itemIds.add(item.getId());
//    }
}
