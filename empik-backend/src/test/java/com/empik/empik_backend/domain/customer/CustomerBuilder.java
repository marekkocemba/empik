package com.empik.empik_backend.domain.customer;

import com.empik.empik_backend.TestSystemConfiguration;
import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;

public class CustomerBuilder {

    private final TestSystemConfiguration testSystemConfiguration;

    public CustomerBuilder(TestSystemConfiguration testSystemConfiguration) {
        this.testSystemConfiguration = testSystemConfiguration;
    }

    public CreateCustomerCommand getCreateCustomerCommand() {
        return new CreateCustomerCommand(testSystemConfiguration.STRING_ONE, testSystemConfiguration.STRING_TWO);
    }
}
