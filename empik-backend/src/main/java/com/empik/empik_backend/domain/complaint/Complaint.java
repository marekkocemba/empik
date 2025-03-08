package com.empik.empik_backend.domain.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("complaints")
@RequiredArgsConstructor
class Complaint {

    @Id
    private Long id;
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
                id,
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
}
