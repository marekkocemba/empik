package com.empik.empik_backend.application.product;

import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import com.empik.empik_backend.domain.product.api.ProductResponse;
import com.empik.empik_backend.domain.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductFacade {

    private final ProductService productService;

    public ProductResponse createProduct(CreateProductCommand command) {
        return productService.createProduct(command);
    }

    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }
}
