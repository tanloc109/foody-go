package com.foodygo.shipping.entity;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String citizenId;

    String photo;

    String motoModel;

    String licensePlate;

    String driverLicenseId;

    String driverLicensePhoto;

    @Builder.Default
    boolean available = true;

    @Builder.Default
    boolean deleted = false;

    @Enumerated(EnumType.STRING)
    ShipperStatus status;

    @OneToMany(mappedBy = "shipper")
    List<ShipperLog> logs;

    @OneToMany(mappedBy = "shipper")
    List<Shipping> shippings;
}
