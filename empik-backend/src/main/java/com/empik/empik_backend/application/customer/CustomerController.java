package com.empik.empik_backend.application.customer;

import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.customer.api.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
class CustomerController {

    private final CustomerFacade customerFacade;

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody @Valid CreateCustomerCommand command) {
        return customerFacade.createCustomer(command);
    }

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerFacade.getCustomers();
    }
}
