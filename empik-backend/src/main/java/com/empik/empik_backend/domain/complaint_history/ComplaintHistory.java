package com.empik.empik_backend.domain.complaint_history;

import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;
import com.empik.empik_backend.domain.complaint_history.api.CreateComplaintHistoryCommand;
import com.empik.empik_backend.infrastructure.entity.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("complaints_history")
@RequiredArgsConstructor
class ComplaintHistory extends AbstractEntity {

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
                getId(),
                complaintId,
                createdDate,
                content);
    }
}
