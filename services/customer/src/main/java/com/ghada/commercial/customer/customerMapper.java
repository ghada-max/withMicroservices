package com.ghada.commercial.customer;

import org.springframework.stereotype.Service;

@Service
public class customerMapper {
    public customer toCustomer(customerRequest request) {
        if(request== null){
            return null;
        }
        return customer.builder().
                firstname(request.firstname).
                lastname(request.lastname)
                .email(request.email)
                .address(request.address)
        .build();
    }


}
