package com.foodygo.location.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "districts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class District {

    @Id
    Integer id;

    String name;

    Integer provinceId;

    Integer type;

    Boolean isDeleted = false;
}
