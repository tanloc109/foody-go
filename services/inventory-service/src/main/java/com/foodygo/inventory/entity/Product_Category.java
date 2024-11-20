package com.foodygo.inventory.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Product_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    ProductGroup productGroups;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category categories;

}
