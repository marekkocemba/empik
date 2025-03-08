package com.empik.empik_backend.domain.customer.api;

import java.time.Instant;

public record CustomerResponse(Long id, String name, String surname, Instant createdDate) {
}
