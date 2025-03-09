package com.empik.empik_backend.domain.complaint_history.api;

public record CreateComplaintHistoryCommand(
         Long complaintId,
         String content) {
}