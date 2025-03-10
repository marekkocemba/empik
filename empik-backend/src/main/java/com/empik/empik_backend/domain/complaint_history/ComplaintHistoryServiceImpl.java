package com.empik.empik_backend.domain.complaint_history;

import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryResponse;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryService;
import com.empik.empik_backend.domain.complaint_history.api.CreateComplaintHistoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintHistoryServiceImpl implements ComplaintHistoryService {

    private final ComplaintHistoryRepository complainthistoryRepository;

    @Override
    public ComplaintHistoryResponse createComplaintHistory(CreateComplaintHistoryCommand command) {

        ComplaintHistory complaintHistory = complainthistoryRepository.save(new ComplaintHistory(command));
        return complaintHistory.toResponse();
    }

    @Override
    public List<ComplaintHistoryResponse> findByComplaintId(Long complaintId) {

        List<ComplaintHistory> complaintHistoryList = complainthistoryRepository.findByComplaintId(complaintId);
        return complaintHistoryList.stream()
                .map(ComplaintHistory::toResponse)
                .toList();
    }
}