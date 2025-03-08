package com.empik.empik_backend.domain.complaint;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

interface ComplaintRepository extends ListCrudRepository<Complaint, Long>{

    Integer countByCustomerIdAndProductId(Long customerId, Long productId);

    Optional<Complaint> findByCustomerIdAndProductId(Long customerId, Long productId);
}