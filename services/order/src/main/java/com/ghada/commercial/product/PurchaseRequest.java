package com.ghada.commercial.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(

        @NotNull(message="Product is mandatory")
        Integer productId,
        @Positive(message="Quantity mandatory")
        Integer quantity
        ) {
}