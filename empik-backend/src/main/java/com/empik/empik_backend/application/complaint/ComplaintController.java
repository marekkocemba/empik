package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.UpdateComplaintCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complaints")
class ComplaintController {

    private final ComplaintFacade complaintFacade;

    @PostMapping
    public ComplaintApplicationResponse createComplaint(@RequestBody @Valid CreateComplaintCommandApplication command) {
        return complaintFacade.createComplaint(command);
    }

    @GetMapping("/{id}")
    public ComplaintApplicationResponse getComplaintById(@PathVariable Long id) {
        return complaintFacade.getComplaintById(id);
    }

    @PatchMapping("/{id}")
    public ComplaintApplicationResponse updateComplaint(@RequestBody @Valid UpdateComplaintCommand command, @PathVariable Long id) {
        return complaintFacade.updateComplaint(command, id);
    }
}
