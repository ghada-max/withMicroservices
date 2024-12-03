package com.ghada.payment.payment.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class notificationProducer {
    private final KafkaTemplate<String,PaymentNotificationRequest> kafkaTemplate;
}
