package com.ghada.commercial.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/payment")
public class paymentController {
    private final paymentService service;

    @PostMapping
    public ResponseEntity<Integer> createPayment(@RequestBody @Valid paymentRequest request)
    {
        return ResponseEntity.ok(service.createPayment(request));
    }
}
