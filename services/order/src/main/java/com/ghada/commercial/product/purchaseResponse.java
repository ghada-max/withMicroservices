package com.ghada.commercial.product;

import java.math.BigDecimal;

public record purchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity


) {
}
