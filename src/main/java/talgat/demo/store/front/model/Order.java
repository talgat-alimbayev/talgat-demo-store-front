package talgat.demo.store.front.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private Long id;

    @NotBlank(message = "Не забудьте адрес доставки")
    private String deliveryAddress;

    @NotBlank(message = "Кому доставить?")
    private String deliveryName;

    @NotBlank(message = "Имейл обязателен!")
    private String email;

    private List<ItemOrder> items = new ArrayList<>();
    private String comment;
    private Long userId;
    public void addItem(ItemOrder item){
        items.add(item);
    }
}
