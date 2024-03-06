package io.miwurster.clean.core;

import java.math.BigDecimal;

public record ProductRequestModel(
    String id,
    String name,
    String description,
    BigDecimal price
) {

}
