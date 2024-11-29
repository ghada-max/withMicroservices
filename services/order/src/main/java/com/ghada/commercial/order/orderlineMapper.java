package com.ghada.commercial.order;

import org.springframework.stereotype.Service;

@Service
public class orderlineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .order(
                        order.builder()
                             .id(request.orderId())
                                .build()
                      )
                .quantity(request.quantity())
                .build();
    }
}
