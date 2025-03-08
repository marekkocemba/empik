package com.empik.empik_backend.domain.customer.api;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerCommand command);

    List<CustomerResponse> getCustomers();

    CustomerResponse getCustomerById(Long customerId);
}
