package io.miwurster.clean.core;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void givenValidProduct_whenValidate_thenReturnTrue() {
        var product = new Product("42", "A better test name", "Test", BigDecimal.ONE);

        assertThat(product.isNameValid()).isTrue();
    }

    @Test
    void givenInvalidName_whenValidateName_thenReturnFalse() {
        var product = new Product("42", "Test", "Test", BigDecimal.ONE);

        assertThat(product.isNameValid()).isFalse();
    }
}
