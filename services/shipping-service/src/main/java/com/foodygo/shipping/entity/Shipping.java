package com.foodygo.shipping.entity;

import com.foodygo.shipping.entity.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

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

    @Column(unique = true)
    Integer orderId;

    Integer branchId;

    Integer customerId;

    @Enumerated(EnumType.STRING)
    ShippingStatus status;

    @Builder.Default
    boolean deleted = false;

    @Builder.Default
    Instant created = Instant.now();

    @ManyToOne
    Shipper shipper;

    @OneToMany(mappedBy = "shipping")
    List<ShipperLog> shippingLogs;
}
