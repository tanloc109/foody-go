package com.foodygo.inventory.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Blob;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fileName;
    String fileType;
    String downloadUrl;

    @ManyToOne
    @JoinColumn(name = "product_group_id")
    ProductGroup productGroups;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    Instant createdAt;
    @LastModifiedDate
    @Column(updatable = false)
    Instant lastModifiedAt;
    String createdBy;
    String lastModifiedBy;
}
