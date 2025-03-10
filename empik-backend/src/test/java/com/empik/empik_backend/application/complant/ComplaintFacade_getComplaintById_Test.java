package com.empik.empik_backend.application.complant;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.application.complaint.CreateComplaintCommandApplication;
import com.empik.empik_backend.infrastructure.exception.ClientException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ComplaintFacade_getComplaintById_Test extends AbstractTest {

    @Test
    void shouldReturnComplaint() {

        //given;
        var customerResponse = customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        var productResponse = productFacade.createProduct(productBuilder.getCreateProductCommand());
        var complaintResponse = complaintFacade.createComplaint(complaintBuilder.getCreateComplaintCommand(customerResponse.id(), productResponse.id()));

        //when
        var result = complaintFacade.getComplaintById(complaintResponse.id());

        //then
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.customerId()).isEqualTo(NUMBER_ONE);
        assertThat(result.productId()).isEqualTo(NUMBER_ONE);
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
    void shouldThrowExceptionWhenComplaintNotFound() {

        //when
        var exception = catchThrowable(() -> complaintFacade.getComplaintById(NUMBER_ONE));

        //then
        assertThat(exception).isInstanceOf(ClientException.class);
    }
}