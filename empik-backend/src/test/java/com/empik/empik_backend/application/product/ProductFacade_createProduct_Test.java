package com.empik.empik_backend.application.product;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductFacade_createProduct_Test extends AbstractTest {

    @Test
    void shouldCreateProduct() {

        //given
        CreateProductCommand command = productBuilder.getCreateProductCommand();

        //when
        var result = productFacade.createProduct(command);

        //then
        assertThat(result.name()).isEqualTo(command.name());
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.createdDate()).isNotNull();
    }
}
