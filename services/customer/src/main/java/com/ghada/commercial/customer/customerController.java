package com.ghada.commercial.customer;

import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class customerController {
    private final customerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid customerRequest request
    ){
return ResponseEntity.ok(service.createCustomer(request));
    }


    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid customerRequest request){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<customer>> findAll(){
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") String customerId
    ){
        return ResponseEntity.ok(service.existById(customerId));
    }

   @GetMapping("/customer-id")
    public ResponseEntity<customer> findById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(service.findById(customerId));
   }
    @DeleteMapping("/customer-id")
    public ResponseEntity<Void> deleteById(@PathVariable("customer-id") String customerId){
        return ResponseEntity.accepted().build();
    }











}
