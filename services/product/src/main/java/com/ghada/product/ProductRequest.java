package com.ghada.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message="product name is required")
        String name,
        @NotNull(message="product description is required")
        String description,
        @Positive(message="product availableQuantity must be positive")
        double availableQuantity,
        @Positive(message="product price must be positive")
        BigDecimal price,
        @Positive(message="product category is required")
        Integer categoryId

) {
}
