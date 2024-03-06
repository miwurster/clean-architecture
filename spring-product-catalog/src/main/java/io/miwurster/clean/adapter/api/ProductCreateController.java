package io.miwurster.clean.adapter.api;

import io.miwurster.clean.adapter.api.representation.ProductDto;
import io.miwurster.clean.adapter.api.requests.ProductCreateRequest;
import io.miwurster.clean.core.IProductCreateBoundary;
import io.miwurster.clean.core.ProductRequestModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class ProductCreateController {

    private final IProductCreateBoundary boundary;

    private final ModelMapper modelMapper = new ModelMapper();

    public ProductDto createProduct(ProductCreateRequest request) {
        var requestModel = modelMapper.map(request, ProductRequestModel.class);

        var responseModel = boundary.createProduct(requestModel);

        return modelMapper.map(responseModel, ProductDto.class);
    }
}
