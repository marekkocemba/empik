package com.empik.empik_backend.domain.customer;

import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.customer.api.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("customers")
@RequiredArgsConstructor
class Customer {

    @Id
    private Long id;
    private String name;
    private String surname;
    private Instant createdDate;

    public Customer(CreateCustomerCommand command) {
        this.name = command.name();
        this.surname = command.surname();
        this.createdDate = Instant.now();}

    public CustomerResponse toResponse() {
        return new CustomerResponse(id, name, surname, createdDate);
    }
}
