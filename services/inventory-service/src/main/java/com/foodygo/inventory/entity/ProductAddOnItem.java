package com.foodygo.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_add_on_item")
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAddOnItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    double price;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_add_on_section_id")
    ProductAddOnSection productAddOnSections;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(updatable = false)
    Instant lastModifiedAt;
    String createdBy;
    String lastModifiedBy;
}
