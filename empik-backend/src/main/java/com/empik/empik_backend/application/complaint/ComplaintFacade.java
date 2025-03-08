package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import com.empik.empik_backend.domain.complaint.api.ComplaintService;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.domain.customer.api.CustomerService;
import com.empik.empik_backend.domain.product.api.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class ComplaintFacade {

    private final ComplaintService complaintService;
    private final CustomerService customerService;
    private final ProductService productService;
    private static final int FIRST_COMPLAINT = 1;

    @Transactional
    public ComplaintResponse createComplaint(CreateComplaintCommandApplication commandApplication) {

        customerService.getCustomerById(commandApplication.customerId());
        productService.getProductById(commandApplication.productId());


        if(complaintService.isComplaintExists(commandApplication.customerId(), commandApplication.productId())){
            return complaintService.incrementComplaintCounter(commandApplication.customerId(), commandApplication.productId());
        }else {
            CreateComplaintCommand command = commandApplication.toCommand(FIRST_COMPLAINT,"Polska");
            return complaintService.createComplaint(command);
        }
    }
}
