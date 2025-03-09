package com.empik.empik_backend.domain.complaint_history;

import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;
import com.empik.empik_backend.domain.complaint_history.api.CreateComplaintHistoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("complaints_history")
@RequiredArgsConstructor
class ComplaintHistory {

    @Id
    private Long id;
    private Long complaintId;
    private Instant createdDate;
    private String content;

    public ComplaintHistory(CreateComplaintHistoryCommand command) {

        this.complaintId = command.complaintId();
        this.content = command.content();
        this.createdDate = Instant.now();
    }

    public ComplaintHistoryResponse toResponse() {
        return new ComplaintHistoryResponse(
                id,
                complaintId,
                createdDate,
                content);
    }
}
