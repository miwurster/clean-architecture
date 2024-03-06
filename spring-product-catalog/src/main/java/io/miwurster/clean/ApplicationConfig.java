package io.miwurster.clean;

import io.miwurster.clean.adapter.api.ProductCreateController;
import io.miwurster.clean.adapter.api.ProductPresenter;
import io.miwurster.clean.adapter.jpa.ProductCreateGateway;
import io.miwurster.clean.adapter.jpa.ProductRepository;
import io.miwurster.clean.core.IProductCreateBoundary;
import io.miwurster.clean.core.IProductCreateGateway;
import io.miwurster.clean.core.IProductFactory;
import io.miwurster.clean.core.IProductPresenter;
import io.miwurster.clean.core.ProductCreateInteractor;
import io.miwurster.clean.core.ProductFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public IProductPresenter productPresenter() {
        return new ProductPresenter();
    }

    @Bean
    public IProductFactory productFactory() {
        return new ProductFactory();
    }

    @Bean
    public IProductCreateGateway productCreateGateway(ProductRepository productRepository) {
        return new ProductCreateGateway(productRepository);
    }

    @Bean
    public IProductCreateBoundary productCreateBoundary(IProductPresenter presenter, IProductFactory factory, IProductCreateGateway gateway) {
        return new ProductCreateInteractor(factory, presenter, gateway);
    }

    @Bean
    public ProductCreateController productCreateController(IProductCreateBoundary boundary) {
        return new ProductCreateController(boundary);
    }
}
