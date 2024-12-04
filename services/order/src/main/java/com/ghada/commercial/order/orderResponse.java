package com.ghada.commercial.order;

import com.ghada.commercial.PaymentMethod;

import java.math.BigDecimal;

public record orderResponse (

        Integer id,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
){
}
