package com.foodygo.location.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Builder
@Table(name = "location_wards")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ward {

    @Id
    Integer id;

    String name;

    @ManyToOne
    District district;

    @Column(name = "type", nullable = false)
    Integer type;

    @Column(name = "is_deleted")
    Boolean isDeleted = false;

    @OneToMany(mappedBy = "ward")
    List<Detail> details;
}
