package com.ghada.commercial;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

        Integer productId,
        String name,
        String description,
        BigDecimal ammount,
        Integer quantity


) {
}
