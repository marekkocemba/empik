package com.empik.empik_backend.domain.complaint.api;

import jakarta.validation.constraints.NotBlank;

public record UpdateComplaintCommand(
         @NotBlank String content) {
}
