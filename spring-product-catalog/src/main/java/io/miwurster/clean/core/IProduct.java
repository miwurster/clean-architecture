package io.miwurster.clean.core;

import java.math.BigDecimal;

public interface IProduct {

    String getId();

    String getName();

    String getDescription();

    BigDecimal getPrice();

    boolean isNameValid();
}
