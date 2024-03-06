package io.miwurster.clean.adapter.api;

import io.miwurster.clean.core.IProductPresenter;
import io.miwurster.clean.core.ProductException;
import io.miwurster.clean.core.ProductResponseModel;

public class ProductPresenter implements IProductPresenter {

    @Override
    public ProductResponseModel prepareSuccessView(ProductResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public ProductResponseModel prepareErrorView(ProductException exception) {
        throw exception;
    }
}
