package io.miwurster.clean.core;

public interface IProductCreateGateway extends IProductExistsGateway {

    void save(IProduct product);
}
