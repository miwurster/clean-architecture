package io.miwurster.clean.core;

public interface IProductPresenter {

    ProductResponseModel prepareSuccessView(ProductResponseModel responseModel);

    ProductResponseModel prepareErrorView(ProductException exception);
}
