package io.miwurster.clean.adapter.api;

import io.miwurster.clean.adapter.api.representation.ProductDto;
import io.miwurster.clean.adapter.api.requests.ProductCreateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductCreateController productCreateController;

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductCreateRequest request) {
        var response = productCreateController.createProduct(request);
        return ResponseEntity.ok(response);
    }
}
