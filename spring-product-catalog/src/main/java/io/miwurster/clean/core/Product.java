package io.miwurster.clean.core;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IProduct {

    private static final int MINIMUM_CHARACTER_LIMIT = 5;

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    @Override
    public boolean isNameValid() {
        return name != null && !name.isBlank() && name.strip().length() >= MINIMUM_CHARACTER_LIMIT;
    }
}
