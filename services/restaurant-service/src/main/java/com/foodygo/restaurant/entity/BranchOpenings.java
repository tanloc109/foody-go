package com.foodygo.restaurant.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "branch_openings")
public class BranchOpenings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Time openingTime;

    Time closingTime;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    Branch branch;
}
