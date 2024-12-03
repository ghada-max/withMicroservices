package com.ghada.payment.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class paymentService {
    private final paymentRepository repository;
    private final paymentMapper mapper;

    public Integer createPayment(paymentRequest request)
    {
        var payment =repository.save(mapper.topayment(request));
        return null;
    }
}
