package com.ghada.commercial.order;


import com.ghada.commercial.product.orderRequest;
import com.ghada.commercial.orderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
