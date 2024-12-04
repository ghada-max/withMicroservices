package com.ghada.commercial.payment;
import com.ghada.commercial.payment.notification.PaymentNotificationRequest;
import com.ghada.commercial.payment.notification.notificationProducer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class paymentService {
    private final paymentRepository repository;
    private final paymentMapper mapper;
    private final notificationProducer notificationProducer;
    public Integer createPayment(paymentRequest request)
    {
        var payment =repository.save(mapper.topayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                   request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return payment.getId();
    }
}
