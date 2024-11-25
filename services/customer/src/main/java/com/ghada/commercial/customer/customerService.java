package com.ghada.commercial.customer;

import com.ghada.commercial.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class customerService {

    private final customerRepository repository;
    private final customerMapper mapper;
    public List<customer> findAllCustomers(){
        return repository.findAll();
    }


    public String createCustomer(customerRequest request) {
      var customer=repository.save(mapper.toCustomer(request));
      return customer.getId();
    }

    public void updateCustomer(customerRequest request) {

        var customer = repository.findById(request.getId())
                .orElseThrow(()-> new CustomerNotFoundException(String.format("cannot update customer")));

      //  mergeCustormer(customer,request);
        repository.save(customer);
 }

    public Boolean existById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public customer findById(String customerId) {
        return repository.findById(customerId).orElseThrow(
                () ->new CustomerNotFoundException(String.format("No customer found here"))
        );
    }

    public void deleteById(String customerId) {
         repository.deleteById(customerId);
    }
}
