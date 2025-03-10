package com.empik.empik_backend.application.complant;

import com.empik.empik_backend.AbstractTest;
import com.empik.empik_backend.infrastructure.exception.ClientException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ComplaintFacade_updateComplaint_Test extends AbstractTest {

    @Test
    void shouldReturnComplaint() throws InterruptedException {

        //given;
        var customerResponse = customerFacade.createCustomer(customerBuilder.getCreateCustomerCommand());
        var productResponse = productFacade.createProduct(productBuilder.getCreateProductCommand());
        var complaintResponse = complaintFacade.createComplaint(complaintBuilder.getCreateComplaintCommand(customerResponse.id(), productResponse.id()));
        var updateComplaintCommand = complaintBuilder.getUpdateComplaintCommand();

        //when
        var result = complaintFacade.updateComplaint(updateComplaintCommand,complaintResponse.id());

        //then
        assertThat(result.id()).isEqualTo(NUMBER_ONE);
        assertThat(result.customerId()).isEqualTo(NUMBER_ONE);
        assertThat(result.productId()).isEqualTo(NUMBER_ONE);
        assertThat(result.content()).isEqualTo(updateComplaintCommand.content());
        assertThat(result.complaintHistory().size()).isEqualTo(NUMBER_TWO.intValue());
        assertThat(result.complaintHistory().get(0).content()).isEqualTo(STRING_ONE);
        assertThat(result.complaintHistory().get(1).content()).isEqualTo(updateComplaintCommand.content());
    }

    @Test
    void shouldThrowExceptionWhenComplaintNotFound() {

        //given;
        var updateComplaintCommand = complaintBuilder.getUpdateComplaintCommand();

        //when
        var exception = catchThrowable(() -> complaintFacade.updateComplaint(updateComplaintCommand,NUMBER_ONE));

        //then
        assertThat(exception).isInstanceOf(ClientException.class);
    }
}