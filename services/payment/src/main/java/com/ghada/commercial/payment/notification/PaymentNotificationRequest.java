package com.ghada.commercial.payment.notification;
import com.ghada.commercial.payment.paymentMethod;

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
