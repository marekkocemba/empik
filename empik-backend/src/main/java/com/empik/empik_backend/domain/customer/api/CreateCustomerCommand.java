package com.empik.empik_backend.domain.customer.api;

import jakarta.validation.constraints.NotBlank;

public record CreateCustomerCommand(
        @NotBlank String name,
        @NotBlank String surname) {
}
