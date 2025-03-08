package com.empik.empik_backend.domain.product;

import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import com.empik.empik_backend.domain.product.api.ProductResponse;
import com.empik.empik_backend.domain.product.api.ProductService;
import com.empik.empik_backend.infrastructure.exception.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(CreateProductCommand command) {

        Product product = productRepository.save(new Product(command));
        return product.toResponse();
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> result = productRepository.findAll();
        return result.stream()
                .map(Product::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ClientException("No product with id: "+ productId))
                .toResponse();
    }
}
