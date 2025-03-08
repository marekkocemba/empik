package com.empik.empik_backend.domain.complaint.api;

public interface ComplaintService {

    ComplaintResponse createComplaint(CreateComplaintCommand command);
    boolean isComplaintExists(Long customerId, Long productId);
    ComplaintResponse incrementComplaintCounter(Long customerId, Long productId);
}
