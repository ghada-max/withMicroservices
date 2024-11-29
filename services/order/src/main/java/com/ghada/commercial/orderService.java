package com.ghada.commercial;
import com.ghada.commercial.Exception.BuisnessException;
import com.ghada.commercial.customer.customerClient;
import com.ghada.commercial.order.*;
import com.ghada.commercial.product.PurchaseRequest;
import com.ghada.commercial.product.productClient;

import com.ghada.commercial.product.orderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Service
public class orderService {

    private final customerClient customerClient;
    private final productClient productClient;
    private final orderRepository orderRepo;
    private final ordermapper mapper;
    private final orderLineService orderlineSer;

    public Integer createOrder(orderRequest request) {

        //check the customer
        var customer=this.customerClient.findCustomerById(request.customerId()).orElseThrow(()-> new BuisnessException("Customer not found"));
        //purchase the products --> product-ms
       this.productClient.purchaseProduct(request.products());
       var order=this.orderRepo.save(mapper.toOrder(request));

       for(PurchaseRequest purchaseRequest: request.products()){
        orderLineService.saveOrderLine(
                new OrderLineRequest(
                        null,
                        order.getId(),


                       purchaseRequest.productId(),
                        purchaseRequest.quantity()

        ));
       }
        //presist order
        //persist order lines
        //start payment process
        //send the roder confirmation -->notification-ms(kafka)


    return null;
    }
}
