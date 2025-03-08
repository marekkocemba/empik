package com.empik.empik_backend.domain.complaint.api;

import java.time.Instant;

public record ComplaintResponse(
        Long id,
        Long customerId,
        Long productId,
        Instant createdDate,
        Instant lastModifiedDate,
        String content,
        Integer complaintCounter,
        String country) {
}
