package com.empik.empik_backend.domain.complaint.api;

public record CreateComplaintCommand(
         Long customerId,
         Long productId,
         String content,
         Integer complaintCounter,
         String country) {

}
