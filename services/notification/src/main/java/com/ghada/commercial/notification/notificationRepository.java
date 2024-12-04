package com.ghada.commercial.notification;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface notificationRepository extends MongoRepository<PaymentConfirmation,String> {
}
