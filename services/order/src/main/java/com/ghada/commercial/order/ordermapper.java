package com.ghada.commercial.order;

import com.ghada.commercial.product.orderRequest;
import org.springframework.stereotype.Service;

@Service
public class ordermapper {
    public order toOrder(orderRequest request) {

        return order.builder()
                .customerId(request.customerId())
                .paymentMethod(request.paymentMethod())
                .refernces(request.reference())
                .totalAmount(request.amount())
                .id(request.id())
                .build();

    }
    public orderResponse fromOrder(order order)
    {
        return new orderResponse(
                order.getId(),
                order.getRefernces(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
