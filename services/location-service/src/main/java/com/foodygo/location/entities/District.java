package com.foodygo.location.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "location_districts")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class District {

    @Id
    Integer id;

    String name;

    @ManyToOne
    Province province;

    @Column(name = "type", nullable = false)
    Integer type;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @OneToMany(mappedBy = "district")
    List<Ward> wards;
}
