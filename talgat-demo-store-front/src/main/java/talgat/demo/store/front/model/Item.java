package talgat.demo.store.front.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
@Data
public class Item {

    private Long id;
    @Size(min = 1, message = "Слишком короткое имя")
    private String name;
    @DecimalMin(value = "0", message = "Цена не может быть ниже нуля")
    private BigDecimal price;
}
