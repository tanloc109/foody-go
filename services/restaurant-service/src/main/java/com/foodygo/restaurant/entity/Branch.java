package com.foodygo.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String hotline;

    @Column(name = "location_id")
    Integer locationId;

    @Column(name = "is_avalable")
    Boolean isAvailable = true;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    List<BranchOpenings> branchOpenings;
}
