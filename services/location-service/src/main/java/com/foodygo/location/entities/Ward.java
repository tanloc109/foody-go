package com.foodygo.location.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wards")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ward {

    @Id
    Integer id;

    String name;

    @ManyToOne
    District district;

    Boolean isDeleted = false;
}
