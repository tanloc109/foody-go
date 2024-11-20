package com.foodygo.location.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "provinces")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Province {

    @Id
    Integer id;

    String slug;

    String name;

    Integer type;

    Boolean isDeleted = false;
}
