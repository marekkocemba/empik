package com.empik.empik_backend.domain.complaint;

import com.empik.empik_backend.InMemoryRepositoryImpl;

import java.util.Optional;

public class ComplaintInMemoryRepository extends InMemoryRepositoryImpl<Complaint, Long> implements ComplaintRepository {

    @Override
    public Long countByCustomerIdAndProductId(Long customerId, Long productId) {
        return data.stream()
                .filter(item -> item.toResponse().customerId().equals(customerId) && item.toResponse().productId().equals(productId))
                .count();

    }

    @Override
    public Optional<Complaint> findByCustomerIdAndProductId(Long customerId, Long productId) {
        return data.stream()
                .filter(item -> item.toResponse().customerId().equals(customerId) && item.toResponse().productId().equals(productId))
                .findFirst();
    }
}
