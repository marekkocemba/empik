package com.empik.empik_backend.domain.complaint.api;

import com.empik.empik_backend.application.complaint.ComplaintApplicationResponse;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;

import java.time.Instant;
import java.util.List;

public record ComplaintResponse(
        Long id,
        Long customerId,
        Long productId,
        Instant createdDate,
        Instant lastModifiedDate,
        String content,
        Integer complaintCounter,
        String country) {

    public ComplaintApplicationResponse toApplicationResponse(List<ComplaintHistoryResponse> complaintHistoryList){
        return new ComplaintApplicationResponse(id,customerId,productId, createdDate, lastModifiedDate,content,complaintCounter,country,complaintHistoryList);
    };
}
