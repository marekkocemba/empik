package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.infrastructure.validator.Ip;
import com.empik.empik_backend.infrastructure.validator.IpNoLocalhost;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateComplaintCommandApplication(
         @NotNull Long customerId,
         @NotNull Long productId,
         @NotBlank String content,
         @Ip @IpNoLocalhost @NotNull String customerIp) {

    public CreateComplaintCommand toCommand(Integer complaintCounter, String country) {
        return new CreateComplaintCommand(customerId,productId,content, complaintCounter,country);
    }
}
