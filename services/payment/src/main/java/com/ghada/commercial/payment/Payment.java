package com.ghada.payment.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="payment")
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;
     private BigDecimal amount;
     @Enumerated(EnumType.STRING)
     private paymentMethod paymentMethod;
     private Integer orderId;
     @CreatedDate
     @Column(updatable = false, nullable=false)
     private LocalDateTime createdDate;
     @LastModifiedDate
     @Column(insertable=false)
     private LocalDateTime lastModifiedDate;
}











