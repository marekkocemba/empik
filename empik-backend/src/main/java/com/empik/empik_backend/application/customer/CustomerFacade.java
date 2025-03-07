package com.empik.empik_backend.application.customer;

import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.customer.api.CustomerResponse;
import com.empik.empik_backend.domain.customer.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CustomerFacade {

    private final CustomerService customerService;

    public CustomerResponse createCustomer(CreateCustomerCommand command) {
        return customerService.createCustomer(command);
    }

    public List<CustomerResponse> getCustomers() {
        return customerService.getCustomers();
    }
}
