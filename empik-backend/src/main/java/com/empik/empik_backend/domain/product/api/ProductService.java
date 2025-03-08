package com.empik.empik_backend.domain.product.api;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(CreateProductCommand command);

    List<ProductResponse> getProducts();

    ProductResponse getProductById(Long productId);
}
