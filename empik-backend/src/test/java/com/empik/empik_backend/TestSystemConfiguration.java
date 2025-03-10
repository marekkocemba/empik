package com.empik.empik_backend;

import com.empik.empik_backend.domain.complaint.ComplaintRepository;
import com.empik.empik_backend.domain.complaint.ComplaintInMemoryRepository;
import com.empik.empik_backend.domain.complaint_history.ComplaintHistoryRepository;
import com.empik.empik_backend.domain.customer.CustomerInMemoryRepository;
import com.empik.empik_backend.domain.customer.CustomerRepository;
import com.empik.empik_backend.domain.complaint_history.ComplaintHistoryInMemoryRepository;
import com.empik.empik_backend.domain.product.ProductInMemoryRepository;
import com.empik.empik_backend.domain.product.ProductRepository;
import com.empik.empik_backend.infrastructure.client.api.IpApiClient;

public class TestSystemConfiguration {

    public final String STRING_ONE = "String ONE";
    public final String STRING_TWO = "String TWO";
    public final Long NUMBER_ONE =1L;
    public final Long NUMBER_TWO =2L;
    public final Long NUMBER_THREE=3L;
    public final Long NUMBER_FOUR =4L;
    public final ComplaintRepository complaintRepository;
    public final ComplaintHistoryRepository complaintHistoryRepository;
    public final CustomerRepository customerRepository;
    public final ProductRepository productRepository;
    public IpApiClient ipApiClient;

    public TestSystemConfiguration(){
        complaintRepository = new ComplaintInMemoryRepository();
        complaintHistoryRepository = new ComplaintHistoryInMemoryRepository();
        customerRepository = new CustomerInMemoryRepository();
        productRepository = new ProductInMemoryRepository();

        ipApiClient = new IpApiClient() {
            @Override
            public String getCountryByRequestIp(String ip) {
                return STRING_ONE;
            }
        };
    }
}
