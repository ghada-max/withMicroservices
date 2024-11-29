package com.ghada.commercial.product;

import com.ghada.commercial.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record orderRequest(
        Integer id,
        String reference,
        @Positive(message="order amount should be positive")
        BigDecimal amount,
        @NotNull(message="order amount should be positive")
        PaymentMethod paymentMethod,
        @NotNull(message="customer should be present")
        @NotEmpty(message="customer should be present")
        @NotBlank(message="customer should be present")
        String customerId,
        @NotEmpty(message="you should at least purchase one product")
        List<PurchaseRequest> products
) {
}
