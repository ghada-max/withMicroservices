package com.ghada.product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

        Integer productId,
        String name,
        String description,
        BigDecimal ammount,
        Integer quantity


) {
}
