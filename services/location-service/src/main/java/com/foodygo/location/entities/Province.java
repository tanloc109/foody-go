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
@Table(name = "provinces")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Province {

    @Id
    Integer id;

    String slug;

    String name;

    Boolean isDeleted = false;

    @OneToMany(mappedBy = "province")
    List<District> districts;
}
