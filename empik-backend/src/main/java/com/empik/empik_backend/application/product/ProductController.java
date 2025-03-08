package com.empik.empik_backend.application.product;

import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import com.empik.empik_backend.domain.product.api.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
class ProductController {

    private final ProductFacade productFacade;

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid CreateProductCommand command) {
        return productFacade.createProduct(command);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productFacade.getProducts();
    }
}
