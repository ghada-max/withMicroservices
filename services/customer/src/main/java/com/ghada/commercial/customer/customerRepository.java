package com.ghada.commercial.customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface customerRepository extends MongoRepository<customer,String> {

}
