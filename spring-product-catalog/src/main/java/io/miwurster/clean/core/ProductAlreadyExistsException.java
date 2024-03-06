package io.miwurster.clean.core;

public class ProductAlreadyExistsException extends ProductException {

    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
