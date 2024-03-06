package io.miwurster.clean.core;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductCreateInteractor implements IProductCreateBoundary {

    private final IProductFactory factory;
    private final IProductPresenter presenter;
    private final IProductCreateGateway gateway;

    @Override
    public ProductResponseModel createProduct(ProductRequestModel requestModel) {
        if (gateway.existsById(requestModel.id())) {
            return presenter.prepareErrorView(new ProductAlreadyExistsException("Product with id " + requestModel.id() + " already in database"));
        }

        var product = factory.create(requestModel.id(), requestModel.name(), requestModel.description(), requestModel.price());

        if (!product.isNameValid()) {
            return presenter.prepareErrorView(new ProductNameInvalidException("Name " + product.getName() + " is not valid"));
        }

        gateway.save(product);

        // TODO: How to deal with and get generated createdAt value from database layer?
        var responseModel = new ProductResponseModel(
            product.getId(), product.getName(), product.getDescription(), product.getPrice(), LocalDateTime.now()
        );

        return presenter.prepareSuccessView(responseModel);
    }
}
