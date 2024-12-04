package com.ghada.commercial.order;


import com.ghada.commercial.product.orderRequest;
import com.ghada.commercial.orderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class orderController {

    private final orderService service;

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid orderRequest request)
    {
        return ResponseEntity.ok(service.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<orderResponse>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<orderResponse> findById(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(service.findById(orderId));
    }
}
