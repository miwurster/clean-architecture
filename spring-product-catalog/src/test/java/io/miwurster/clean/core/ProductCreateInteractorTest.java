package io.miwurster.clean.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProductCreateInteractorTest {

    private IProductFactory mockedFactory;
    private IProductPresenter mockedPresenter;
    private IProductCreateGateway mockedGateway;

    @BeforeEach
    void beforeEach() {
        mockedFactory = Mockito.mock(IProductFactory.class);
        mockedPresenter = Mockito.mock(IProductPresenter.class);
        mockedGateway = Mockito.mock(IProductCreateGateway.class);
    }

    @Test
    void givenValidProductProperties_whenCreate_thenSaveItAndPrepareSuccessView() throws Exception {
        // Given
        var requestModel = new ProductRequestModel("TestId", "ValidTestName", "Test description", BigDecimal.TEN);
        var product = new Product("001", "ValidName", "Some Description", BigDecimal.TEN);
        var givenResponseModel = new ProductResponseModel(
            product.getId(), product.getName(), product.getDescription(), product.getPrice(), LocalDateTime.now()
        );

        Mockito.when(mockedGateway.existsById(requestModel.id())).thenReturn(false);
        Mockito
            .when(mockedFactory.create(requestModel.id(), requestModel.name(), requestModel.description(), requestModel.price()))
            .thenReturn(product);
        Mockito.when(mockedPresenter.prepareSuccessView(any())).thenReturn(givenResponseModel);

        var interactor = new ProductCreateInteractor(mockedFactory, mockedPresenter, mockedGateway);

        // When
        var verifyResponseModel = interactor.createProduct(requestModel);

        // Then
        Mockito.verify(mockedGateway, Mockito.times(1)).save(product);
        Mockito.verify(mockedGateway, Mockito.times(1)).existsById(requestModel.id());
        Mockito.verify(mockedPresenter, Mockito.times(1)).prepareSuccessView(any());

        assertThat(verifyResponseModel.id()).isEqualTo(givenResponseModel.id());
        assertThat(verifyResponseModel.name()).isEqualTo(givenResponseModel.name());
        assertThat(verifyResponseModel.description()).isEqualTo(givenResponseModel.description());
        assertThat(verifyResponseModel.price()).isEqualTo(givenResponseModel.price());
        assertThat(verifyResponseModel.createdAt()).isEqualTo(givenResponseModel.createdAt());
    }
}
