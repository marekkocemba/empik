package com.empik.empik_backend.application.complant;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.application.complaint.CreateComplaintCommandApplication;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;
import com.empik.empik_backend.domain.customer.api.CreateCustomerCommand;
import com.empik.empik_backend.domain.product.api.CreateProductCommand;
import com.empik.empik_backend.infrastructure.exception.ClientException;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ComplaintFacade_createComplaint_Test extends AbstractTest {

    @Test
    void shouldCreateComplaint() {

        //given
        customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        var customerResponse = customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        productFacade.createProduct(productBuilder.getCreateProductCommand());
        var productResponse = productFacade.createProduct(productBuilder.getCreateProductCommand());
        CreateComplaintCommandApplication command = complaintBuilder.getCreateComplaintCommand(customerResponse.id(), productResponse.id());

        //when
        var result = complaintFacade.createComplaint(command);

        //then
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.customerId()).isEqualTo(NUMBER_THREE);
        assertThat(result.productId()).isEqualTo(NUMBER_TWO);
        assertThat(result.createdDate()).isNotNull();
        assertThat(result.lastModifiedDate()).isNotNull();
        assertThat(result.content()).isEqualTo(STRING_ONE);
        assertThat(result.complaintCounter()).isEqualTo(NUMBER_ONE.intValue());
        assertThat(result.country()).isEqualTo(STRING_ONE);
        assertThat(result.complaintHistory().size()).isEqualTo(NUMBER_ONE.intValue());
        var resultHistory = result.complaintHistory().get(0);
        assertThat(resultHistory.id()).isEqualTo(NUMBER_ONE);
        assertThat(resultHistory.complaintId()).isEqualTo(NUMBER_ONE);
        assertThat(resultHistory.createdDate()).isNotNull();
        assertThat(resultHistory.content()).isEqualTo(STRING_ONE);
    }

    @Test
    void sameComplaintShouldIncreaseComplainCounter() {

        //given
        var customerResponse = customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        var productResponse = productFacade.createProduct(productBuilder.getCreateProductCommand());
        CreateComplaintCommandApplication command = complaintBuilder.getCreateComplaintCommand(customerResponse.id(), productResponse.id());

        //when
        var result1 = complaintFacade.createComplaint(command);
        var result2 = complaintFacade.createComplaint(command);

        //then
        assertThat(result1.complaintCounter()).isEqualTo(NUMBER_ONE.intValue());
        assertThat(result2.complaintCounter()).isEqualTo(NUMBER_TWO.intValue());

    }

    @Test
    void sameComplaintShouldNotIncreaseComplainHistorySize() {

        //given
        var customerResponse = customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        var productResponse = productFacade.createProduct(productBuilder.getCreateProductCommand());
        CreateComplaintCommandApplication command = complaintBuilder.getCreateComplaintCommand(customerResponse.id(), productResponse.id());

        //when
        var result1 = complaintFacade.createComplaint(command);
        var result2 = complaintFacade.createComplaint(command);

        //then
        assertThat(result1.complaintHistory().size()).isEqualTo(NUMBER_ONE.intValue());
        assertThat(result2.complaintHistory().size()).isEqualTo(NUMBER_ONE.intValue());

    }

    @Test
    void shouldThrowExceptionWhenProductOrCustomerNotFound() {

        //given
        CreateComplaintCommandApplication command = complaintBuilder.getCreateComplaintCommand(NUMBER_ONE, NUMBER_ONE);

        //when
        var exception = catchThrowable(() -> complaintFacade.createComplaint(command));

        //then
        assertThat(exception).isInstanceOf(ClientException.class);

    }
}