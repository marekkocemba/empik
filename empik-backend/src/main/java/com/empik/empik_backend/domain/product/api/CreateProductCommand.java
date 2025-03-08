package com.empik.empik_backend.domain.product.api;

import jakarta.validation.constraints.NotBlank;

public record CreateProductCommand(
        @NotBlank String name) {
}
