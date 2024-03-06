package io.miwurster.clean.adapter.jpa;

import io.miwurster.clean.core.IProduct;
import io.miwurster.clean.core.IProductCreateGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductCreateGateway implements IProductCreateGateway {

    private final ProductRepository repository;

    @Override
    public void save(IProduct product) {
        var entity = new ProductSchema();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());

        repository.save(entity);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }
}
