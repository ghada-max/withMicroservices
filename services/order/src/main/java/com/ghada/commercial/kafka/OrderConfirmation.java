package com.ghada.commercial.kafka;

import com.ghada.commercial.PaymentMethod;
import com.ghada.commercial.customerResponse.CustomerResponse;
import com.ghada.commercial.product.purchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<purchaseResponse>  products
) {
}
