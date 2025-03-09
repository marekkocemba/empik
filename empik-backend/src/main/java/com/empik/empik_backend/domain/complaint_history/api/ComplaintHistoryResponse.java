package com.empik.empik_backend.domain.complaint_history.api;

import java.time.Instant;

public record ComplaintHistoryResponse(
        Long id,
        Long complaintId,
        Instant createdDate,
        String content) {
}
