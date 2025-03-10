package com.empik.empik_backend.domain.complaint_history;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ComplaintHistoryRepository extends ListCrudRepository<ComplaintHistory, Long>{

    List<ComplaintHistory> findByComplaintId(Long complaintId);
}