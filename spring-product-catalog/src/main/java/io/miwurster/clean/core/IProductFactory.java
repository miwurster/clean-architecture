package io.miwurster.clean.core;

import java.math.BigDecimal;

public interface IProductFactory {

    IProduct create(String id, String name, String description, BigDecimal price);
}
