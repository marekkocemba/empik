package com.empik.empik_backend.domain.customer.api;

public record CustomerResponse(Long id, String name, String surname, java.time.Instant createdDate) {
}
