package com.foodygo.location.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "districts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class District {

    @Id
    Integer id;

    String name;

    @ManyToOne
    Province province;

    Boolean isDeleted = false;

    @OneToMany(mappedBy = "district")
    List<Ward> wards;
}
