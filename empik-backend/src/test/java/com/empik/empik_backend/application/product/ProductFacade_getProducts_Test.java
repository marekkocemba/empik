package com.empik.empik_backend.application.product;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductFacade_getProducts_Test extends AbstractTest {

    @Test
    void shouldReturnOneProduct() {

        //given
        CreateProductCommand command = productBuilder.getCreateProductCommand();
        productFacade.createProduct(command);

        //when
        var results = productFacade.getProducts();

        //then
        assertThat(results.size()).isOne();
        var result = results.get(0);
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.name()).isEqualTo(command.name());
    }

    @Test
    void shouldReturnEmptyList() {

        //when
        var results = productFacade.getProducts();

        //then
        assertThat(results.size()).isZero();
    }
}
