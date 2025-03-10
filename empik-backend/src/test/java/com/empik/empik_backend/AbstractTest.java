package com.empik.empik_backend;

import com.empik.empik_backend.application.complaint.ComplaintFacade;
import com.empik.empik_backend.application.customer.CustomerFacade;
import com.empik.empik_backend.application.product.ProductFacade;
import com.empik.empik_backend.domain.complaint.ComplaintBuilder;
import com.empik.empik_backend.domain.complaint.ComplaintServiceImpl;
import com.empik.empik_backend.domain.complaint.api.ComplaintService;
import com.empik.empik_backend.domain.complaint_history.ComplaintHistoryServiceImpl;
import com.empik.empik_backend.domain.complaint_history.api.ComplaintHistoryService;
import com.empik.empik_backend.domain.customer.CustomerBuilder;
import com.empik.empik_backend.domain.customer.CustomerServiceImpl;
import com.empik.empik_backend.domain.customer.api.CustomerService;
import com.empik.empik_backend.domain.complaint_history.ComplaintHistoryBuilder;
import com.empik.empik_backend.domain.product.ProductBuilder;
import com.empik.empik_backend.domain.product.ProductServiceImpl;
import com.empik.empik_backend.domain.product.api.ProductService;
import com.empik.empik_backend.infrastructure.client.api.IpApiClient;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {

    protected Long NUMBER_ONE;
    protected Long NUMBER_TWO;
    protected Long NUMBER_THREE;
    protected Long NUMBER_FOUR;
    protected String STRING_ONE;
    protected String STRING_TWO;
    protected TestSystemConfiguration configuration;

    protected ProductFacade productFacade;
    ;
    protected CustomerFacade customerFacade;
    protected ComplaintFacade complaintFacade;

    protected ProductBuilder productBuilder;
    ;
    protected CustomerBuilder customerBuilder;
    protected ComplaintBuilder complaintBuilder;
    protected ComplaintHistoryBuilder complaintHistoryBuilder;

    @BeforeEach
    public void setUp() {

        configuration = new TestSystemConfiguration();
        this.STRING_ONE = configuration.STRING_ONE;
        this.STRING_TWO = configuration.STRING_TWO;
        this.NUMBER_ONE = configuration.NUMBER_ONE;
        this.NUMBER_TWO = configuration.NUMBER_TWO;
        this.NUMBER_THREE= configuration.NUMBER_THREE;
        this.NUMBER_FOUR = configuration.NUMBER_FOUR;
        initBuilders(configuration);
        initFacades(configuration);
    }

    private void initFacades(TestSystemConfiguration configuration) {

        ProductService productService = new ProductServiceImpl(configuration.productRepository);
        CustomerService customerService = new CustomerServiceImpl(configuration.customerRepository);
        ComplaintService complaintService = new ComplaintServiceImpl(configuration.complaintRepository);
        ComplaintHistoryService complaintHistoryService = new ComplaintHistoryServiceImpl(configuration.complaintHistoryRepository);

        IpApiClient ipApiClient = configuration.ipApiClient;

        productFacade = new ProductFacade(productService);
        customerFacade = new CustomerFacade(customerService);
        complaintFacade = new ComplaintFacade(complaintService, complaintHistoryService, customerService, productService, ipApiClient);
    }

    private void initBuilders(TestSystemConfiguration configuration) {
        productBuilder = new ProductBuilder(configuration);
        customerBuilder = new CustomerBuilder(configuration);
        complaintBuilder = new ComplaintBuilder(configuration);
        complaintHistoryBuilder = new ComplaintHistoryBuilder(configuration);
    }
}
