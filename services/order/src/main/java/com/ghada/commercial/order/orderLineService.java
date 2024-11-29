package com.ghada.commercial.order;
import com.ghada.commercial.order.orderLineRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class orderLineService {
    private final orderLineRepository repository;
    private  final orderlineMapper mapper;
    public  Integer saveOrderLine(OrderLineRequest request) {
     var order=mapper.toOrderLine(request);
     return repository.save(order).getId();
    }
}
