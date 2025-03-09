package com.empik.empik_backend.domain.complaint_history.api;

import java.util.List;

public interface ComplaintHistoryService {

    ComplaintHistoryResponse createComplaintHistory(CreateComplaintHistoryCommand command);

    List<ComplaintHistoryResponse> findByComplaintId(Long id);
}
