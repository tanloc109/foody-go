package com.foodygo.payment.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    PaymentMethod paymentMethod;
}
