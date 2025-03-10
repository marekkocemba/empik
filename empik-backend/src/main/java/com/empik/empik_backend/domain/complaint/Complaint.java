package com.empik.empik_backend.domain.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.domain.complaint.api.UpdateComplaintCommand;
import com.empik.empik_backend.infrastructure.entity.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("complaints")
@RequiredArgsConstructor
class Complaint extends AbstractEntity {

    private Long customerId;
    private Long productId;
    private Instant createdDate;
    private Instant lastModifiedDate;
    private String content;
    private Integer complaintCounter;
    private String country;
    @Version
    private Integer version;

    public Complaint(CreateComplaintCommand command) {

        this.customerId = command.customerId();
        this.productId = command.productId();
        this.content = command.content();
        this.createdDate = Instant.now();
        this.lastModifiedDate = Instant.now();
        this.content = command.content();
        this.complaintCounter = command.complaintCounter();
        this.country = command.country();
    }

    public ComplaintResponse toResponse() {
        return new ComplaintResponse(
                getId(),
                customerId,
                productId,
                createdDate,
                lastModifiedDate,
                content,
                complaintCounter,
                country);
    }

    public void incrementComplaintCounter() {
        this.complaintCounter++;
        this.lastModifiedDate = Instant.now();
    }

    public void update(UpdateComplaintCommand command) {
        this.content = command.content();
        this.lastModifiedDate = Instant.now();
    }
}
