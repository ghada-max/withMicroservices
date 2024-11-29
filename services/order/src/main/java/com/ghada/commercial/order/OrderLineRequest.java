package com.ghada.commercial.order;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record OrderLineRequest(

         Integer id,
         Integer orderId,

         Integer productId,

         Integer quantity
){

}