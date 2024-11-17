package com.foodygo.shipping.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Double distance;

    Double fee;

    Integer orderId;

    @Builder.Default
    boolean deleted = false;

    @ManyToOne
    Shipper shipper;
}
