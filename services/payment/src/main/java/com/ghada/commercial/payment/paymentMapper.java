package com.ghada.payment.payment;

public class paymentMapper {
    public Payment topayment(paymentRequest request) {
        return Payment.builder()
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .id(request.id())
                .amount(request.amount())
                .build();
    }
}
