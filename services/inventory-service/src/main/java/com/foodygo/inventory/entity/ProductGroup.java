package com.foodygo.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_group")
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    double price;
    String description;

    Instant prepareTime;

    @OneToMany(mappedBy = "productGroups", fetch = FetchType.LAZY)
    Set<Product_Category> product_categories;

    @OneToMany(mappedBy = "productGroups", fetch = FetchType.LAZY)
    Set<Product> products;

    @OneToMany(mappedBy = "productGroups", fetch = FetchType.LAZY)
    Set<Image> images;

    @OneToMany(mappedBy = "productGroups", fetch = FetchType.LAZY)
    Set<ProductAddOnSection> productAddOnSections;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(updatable = false)
    Instant lastModifiedAt;
    String createdBy;
    String lastModifiedBy;
}
