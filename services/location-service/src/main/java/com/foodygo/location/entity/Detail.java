package com.foodygo.location.entity;

import com.foodygo.location.enums.LocationType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Detail {
    Integer id;
    String detail;
    LocationType type;
    String longitude;
    String latitude;
    Integer user_id;
    Boolean isDefault;
    Integer brand_id;
    Boolean isDeleted;
}
