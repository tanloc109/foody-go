package com.foodygo.shipping.entity;

import com.foodygo.shipping.entity.enums.ShipperLogAction;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShipperLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer orderId;

    Instant time = Instant.now();

    ShipperLogAction action;

    @Builder.Default
    boolean deleted = false;

    @ManyToOne
    Shipper shipper;

    @ManyToOne
    Shipping shipping;
}
