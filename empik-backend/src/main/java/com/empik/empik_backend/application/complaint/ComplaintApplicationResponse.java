package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;

import java.time.Instant;
import java.util.List;

public record ComplaintApplicationResponse(
        Long id,
        Long customerId,
        Long productId,
        Instant createdDate,
        Instant lastModifiedDate,
        String content,
        Integer complaintCounter,
        String country,
        List<ComplaintHistoryResponse> complaintHistory) {
}
