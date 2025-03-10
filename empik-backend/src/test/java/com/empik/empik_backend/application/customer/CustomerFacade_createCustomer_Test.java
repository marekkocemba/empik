package com.empik.empik_backend.application.customer;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerFacade_createCustomer_Test extends AbstractTest {

    @Test
    void shouldCreateProduct() {

        //given
        CreateCustomerCommand command = customerBuilder.getCreateCustomerCommand();

        //when
        var result = customerFacade.createCustomer(command);

        //then
        assertThat(result.name()).isEqualTo(STRING_ONE);
        assertThat(result.surname()).isEqualTo(STRING_TWO);
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.createdDate()).isNotNull();
    }
}
