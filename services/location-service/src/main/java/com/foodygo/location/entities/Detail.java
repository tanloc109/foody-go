package com.foodygo.location.entities;

import com.foodygo.location.enums.LocationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Detail {

    @Id
    Integer id;

    String detail;

    @Enumerated(EnumType.STRING)
    LocationType type;

    Integer provinceId;

    Integer districtId;

    Integer wardId;

    String longitude;

    String latitude;

    Integer userId;

    Boolean isDefault;

    Integer brandId;

    Boolean isDeleted;

}
