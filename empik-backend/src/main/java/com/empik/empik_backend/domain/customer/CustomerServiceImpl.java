package com.empik.empik_backend.domain.customer;

import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.customer.api.CustomerResponse;
import com.empik.empik_backend.domain.customer.api.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CreateCustomerCommand command) {

        Customer customer = customerRepository.save(new Customer(command));
        return customer.toResponse();
    }

    @Override
    public List<CustomerResponse> getCustomers() {

        List<Customer> result = customerRepository.findAll();
        return result.stream()
                .map(Customer::toResponse)
                .toList();
    }
}
