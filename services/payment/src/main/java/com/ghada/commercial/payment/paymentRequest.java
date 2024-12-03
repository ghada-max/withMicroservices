package com.ghada.payment.payment;

import java.math.BigDecimal;

public record paymentRequest(
        Integer id,
        BigDecimal amount,
        paymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer

) {
}
