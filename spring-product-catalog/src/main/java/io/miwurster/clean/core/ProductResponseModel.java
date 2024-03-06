package io.miwurster.clean.core;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponseModel(
    String id,
    String name,
    String description,
    BigDecimal price,
    LocalDateTime createdAt
) {

}
