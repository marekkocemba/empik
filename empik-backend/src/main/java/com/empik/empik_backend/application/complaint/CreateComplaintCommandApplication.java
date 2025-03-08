package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateComplaintCommandApplication(
         @NotNull Long customerId,
         @NotNull Long productId,
         @NotBlank String content) {

    public CreateComplaintCommand toCommand(Integer complaintCounter, String country) {
        return new CreateComplaintCommand(customerId,productId,content, complaintCounter,country);
    }
}
