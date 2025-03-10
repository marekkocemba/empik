package com.empik.empik_backend.domain.complaint;

import com.empik.empik_backend.TestSystemConfiguration;
import com.empik.empik_backend.application.complaint.CreateComplaintCommandApplication;
import com.empik.empik_backend.domain.complaint.api.UpdateComplaintCommand;

import java.time.LocalDate;

public class ComplaintBuilder {

    private final TestSystemConfiguration testSystemConfiguration;

    public ComplaintBuilder(TestSystemConfiguration testSystemConfiguration) {
        this.testSystemConfiguration = testSystemConfiguration;
    }

    public CreateComplaintCommandApplication getCreateComplaintCommand(Long customerId, Long productId) {
        return new CreateComplaintCommandApplication(customerId, productId, testSystemConfiguration.STRING_ONE, testSystemConfiguration.STRING_TWO);
    }

    public UpdateComplaintCommand getUpdateComplaintCommand() {
        return new UpdateComplaintCommand(LocalDate.now().toString());
    }
}