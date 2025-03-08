package com.empik.empik_backend.domain.product.api;

import java.time.Instant;

public record ProductResponse(Long id, String name, Instant createdDate) {
}
