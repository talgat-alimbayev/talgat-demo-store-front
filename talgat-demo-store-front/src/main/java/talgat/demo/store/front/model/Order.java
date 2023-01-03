package talgat.demo.store.front.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
public class Order {
    private Long id;

    @NotBlank(message = "Не забудьте адрес доставки")
    private String deliveryAddress;

    @NotBlank(message = "Кому доставить?")
    private String deliveryName;

    @NotBlank(message = "Имейл обязателен!")
    private String email;

    private Set<Long> itemIds = new HashSet<>();
    private BigDecimal orderTotal;
    private String comment;
    public void addItem(Item item){
        itemIds.add(item.getId());
    }
}
