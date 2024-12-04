package com.ghada.commercial;
import com.ghada.commercial.Exception.BuisnessException;
import com.ghada.commercial.customer.customerClient;
import com.ghada.commercial.kafka.OrderConfirmation;
import com.ghada.commercial.order.*;
import com.ghada.commercial.payment.PaymentClient;
import com.ghada.commercial.payment.PaymentRequest;
import com.ghada.commercial.product.PurchaseRequest;
import com.ghada.commercial.product.productClient;
import com.ghada.commercial.kafka.orderProducer;

import com.ghada.commercial.product.orderRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class orderService {

    private final customerClient customerClient;
    private final productClient productClient;
    private final orderRepository orderRepo;
    private final ordermapper mapper;
    private final orderLineService orderlineSer;
    private final orderProducer orderProducer;
    private final PaymentClient paymentClient;
    public Integer createOrder(orderRequest request) {

        //check the customer
        var customer=this.customerClient.findCustomerById(request.customerId()).orElseThrow(()-> new BuisnessException("Customer not found"));
        //purchase the products --> product-ms
     var purchasedProduct=this.productClient.purchaseProduct(request.products());
       var order=this.orderRepo.save(mapper.toOrder(request));

       for(PurchaseRequest purchaseRequest: request.products()){
        orderlineSer.saveOrderLine(
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
       var paymentRequest=new PaymentRequest(
               request.amount(),
               request.paymentMethod(),
               order.getId(),
               order.getRefernces(),
               customer

       );
       paymentClient.requestOrderPayment(paymentRequest);
       orderProducer.sendOrderConfirmation(
               new OrderConfirmation(
                       request.reference(),
                       request.amount(),
                       request.paymentMethod(),
                       customer,purchasedProduct
               )

       );
    return order.getId();
    }

    public List<orderResponse> findAll() {
        return orderRepo.findAll().stream().map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public orderResponse findById(Integer orderId) {
        return orderRepo.findById(orderId).map(mapper::fromOrder).orElseThrow(()-> new EntityNotFoundException("order with id  not found"));
    }
}
