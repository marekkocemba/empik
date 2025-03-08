package com.empik.empik_backend.domain.product;

import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import com.empik.empik_backend.domain.product.api.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("products")
@RequiredArgsConstructor
class Product {

    @Id
    private Long id;
    private String name;
    private Instant createdDate;

    public Product(CreateProductCommand command) {
        this.name = command.name();
        this.createdDate = Instant.now();}

    public ProductResponse toResponse() {
        return new ProductResponse(id, name, createdDate);
    }
}
