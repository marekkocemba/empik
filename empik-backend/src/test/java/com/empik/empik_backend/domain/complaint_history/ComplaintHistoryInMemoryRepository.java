package com.empik.empik_backend.domain.complaint_history;

import com.empik.empik_backend.InMemoryRepositoryImpl;


import java.util.List;

    public class ComplaintHistoryInMemoryRepository extends InMemoryRepositoryImpl<ComplaintHistory, Long> implements ComplaintHistoryRepository {
        @Override
        public List<ComplaintHistory> findByComplaintId(Long complaintId) {
            return data.stream()
                    .filter(item -> item.toResponse().complaintId().equals(complaintId))
                    .toList();
        }
    }
