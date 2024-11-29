package com.ghada.commercial.customer;

import com.ghada.commercial.customerResponse.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@FeignClient(
            name="customer",
            url="${application.properties.config.customer-url}"
    )
    public interface customerClient {

        @GetMapping("/{customer-id}")
        Optional<CustomerResponse> findCustomerById(
                @PathVariable("cutomer-id") String customerId
        );
}
