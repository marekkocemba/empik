package com.empik.empik_backend.application.customer;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerFacade_getCustomers_Test extends AbstractTest {

    @Test
    void shouldReturnOneCustomer() {

        //given
        CreateCustomerCommand command = customerBuilder.getCreateCustomerCommand();
        customerFacade.createCustomer(command);

        //when
        var results = customerFacade.getCustomers();

        //then

        assertThat(results.size()).isOne();
        var result = results.get(0);
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.name()).isEqualTo(command.name());
    }

    @Test
    void shouldReturnEmptyList() {

        //when
        var results = customerFacade.getCustomers();

        //then
        assertThat(results.size()).isZero();
    }
}
