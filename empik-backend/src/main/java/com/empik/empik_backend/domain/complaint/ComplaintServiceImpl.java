package com.empik.empik_backend.domain.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import com.empik.empik_backend.domain.complaint.api.ComplaintService;
import com.empik.empik_backend.domain.complaint.api.CreateComplaintCommand;
import com.empik.empik_backend.domain.complaint.api.UpdateComplaintCommand;
import com.empik.empik_backend.infrastructure.exception.ClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Override
    public ComplaintResponse createComplaint(CreateComplaintCommand command) {

        Complaint complaint = complaintRepository.save(new Complaint(command));
        return complaint.toResponse();
    }

    @Override
    public boolean isComplaintExists(Long customerId, Long productId) {
        return complaintRepository.countByCustomerIdAndProductId(customerId, productId) > 0;
    }

    @Override
    public ComplaintResponse incrementComplaintCounter(Long customerId, Long productId) {

        Complaint complaint = complaintRepository.findByCustomerIdAndProductId(customerId, productId)
                .orElseThrow(() -> new ClientException("No complaint with customerId: "+customerId+" and productId: "+productId));

        complaint.incrementComplaintCounter();
        complaintRepository.save(complaint);
        return complaint.toResponse();
    }

    @Override
    public ComplaintResponse getComplaintById(Long id) {
        Complaint complaint = getComplaint(id);
        return complaint.toResponse();
    }

    @Override
    public ComplaintResponse updateComplaint(UpdateComplaintCommand command, Long id) {
        Complaint complaint = getComplaint(id);
        complaint.update(command);
        complaintRepository.save(complaint);
        return complaint.toResponse();
    }

    private Complaint getComplaint(Long id){
        return complaintRepository.findById(id)
                .orElseThrow(() -> new ClientException("No complaint with id: "+id));
    }
}
