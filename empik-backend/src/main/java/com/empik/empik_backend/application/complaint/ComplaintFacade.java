package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import com.empik.empik_backend.domain.complaint.api.ComplaintService;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryService;
import com.empik.empik_backend.domain.complaint_history.api.CreateComplaintHistoryCommand;
import com.empik.empik_backend.domain.customer.api.CustomerService;
import com.empik.empik_backend.domain.product.api.ProductService;
import com.empik.empik_backend.infrastructure.client.api.IpApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ComplaintFacade {

    private final ComplaintService complaintService;
    private final ComplaintHistoryService complaintHistoryService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final IpApiClient ipApiClient;
    private static final int FIRST_COMPLAINT = 1;

    @Transactional
    public ComplaintApplicationResponse createComplaint(CreateComplaintCommandApplication commandApplication) {

        customerService.getCustomerById(commandApplication.customerId());
        productService.getProductById(commandApplication.productId());

        if(complaintService.isComplaintExists(commandApplication.customerId(), commandApplication.productId())){

            ComplaintResponse complaintResponse = complaintService.incrementComplaintCounter(commandApplication.customerId(), commandApplication.productId());
            List<ComplaintHistoryResponse> complaintHistoryResponseList = complaintHistoryService.findByComplaintId(complaintResponse.id());
            return complaintResponse.toApplicationResponse(complaintHistoryResponseList);
        }else {

            var country = ipApiClient.getCountryByRequestIp(commandApplication.customerIp());
            CreateComplaintCommand command = commandApplication.toCommand(FIRST_COMPLAINT,country);
            ComplaintResponse complaintResponse = complaintService.createComplaint(command);
            ComplaintHistoryResponse complaintHistoryResponse = complaintHistoryService.createComplaintHistory(new CreateComplaintHistoryCommand(complaintResponse.id(), complaintResponse.content()));
            return complaintResponse.toApplicationResponse(List.of(complaintHistoryResponse));
        }

    }
}
