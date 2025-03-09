package com.empik.empik_backend.application.complaint;

import com.empik.empik_backend.domain.complaint.api.ComplaintResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/complaints")
class ComplaintController {

    private final ComplaintFacade complaintFacade;

    @PostMapping
    public ComplaintApplicationResponse createComplaint(@RequestBody @Valid CreateComplaintCommandApplication command) {
        return complaintFacade.createComplaint(command);
    }
}
