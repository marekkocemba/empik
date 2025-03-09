package com.empik.empik_backend.domain.complaint.api;

import jakarta.validation.Valid;

public interface ComplaintService {

    ComplaintResponse createComplaint(CreateComplaintCommand command);
    boolean isComplaintExists(Long customerId, Long productId);
    ComplaintResponse incrementComplaintCounter(Long customerId, Long productId);
    ComplaintResponse getComplaintById(Long id);
    ComplaintResponse updateComplaint(UpdateComplaintCommand command, Long id);
}
