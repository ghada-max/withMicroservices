package com.ghada.commercial.payment;

import com.ghada.commercial.PaymentMethod;
import com.ghada.commercial.customerResponse.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
