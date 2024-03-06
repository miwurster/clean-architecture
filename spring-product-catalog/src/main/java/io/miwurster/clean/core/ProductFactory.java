package io.miwurster.clean.core;

import java.math.BigDecimal;

public class ProductFactory implements IProductFactory {

    @Override
    public IProduct create(String id, String name, String description, BigDecimal price) {
        return Product.builder()
            .id(id)
            .name(name)
            .description(description)
            .price(price)
            .build();
    }
}
