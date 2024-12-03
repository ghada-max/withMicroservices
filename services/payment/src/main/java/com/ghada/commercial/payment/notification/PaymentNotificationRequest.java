package com.ghada.payment.payment.notification;
import com.ghada.payment.payment.paymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(

        String orderReference,
        BigDecimal amount,
        paymentMethod paymentMethod,
        String customerFirstname,
        String customerLastName,
        String customerEmail

) {
}
