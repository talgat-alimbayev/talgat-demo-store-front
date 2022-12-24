package talgat.demo.store.front.model;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
@Data
public class Item {

    private Long id;

    private String name;

    private BigDecimal price;
}
