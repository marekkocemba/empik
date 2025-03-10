package com.empik.empik_backend.domain.product;

import com.empik.empik_backend.TestSystemConfiguration;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;

public class ProductBuilder {

    private final TestSystemConfiguration testSystemConfiguration;

    public ProductBuilder(TestSystemConfiguration testSystemConfiguration) {
        this.testSystemConfiguration = testSystemConfiguration;
    }

    public CreateProductCommand getCreateProductCommand(){
        return new CreateProductCommand("Fanta");
    }
}
