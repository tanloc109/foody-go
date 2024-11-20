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
@Table(name = "product_add_on_section")
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAddOnSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    boolean isRequired;
    Integer maxChoice;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    ProductGroup productGroups;

    @OneToMany(mappedBy = "productAddOnSections", fetch = FetchType.LAZY)
    Set<ProductAddOnItem> productAddOnItems;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(updatable = false)
    Instant lastModifiedAt;
    String createdBy;
    String lastModifiedBy;
}
