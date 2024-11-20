//package com.foodygo.location.entities;
//
//import com.foodygo.location.enums.LocationType;
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//@Data
//@Document(collection = "details")
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class Detail {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Integer id;
//
//    String detail;
//
//    @Enumerated(EnumType.STRING)
//    LocationType type;
//
//    String longitude;
//
//    String latitude;
//
//    @Column(name = "user_id")
//    Integer userId;
//
//    @Column(name = "is_default")
//    Boolean isDefault;
//
//    @Column(name = "brand_id")
//    Integer brandId;
//
//    @Column(name = "is_deleted")
//    Boolean isDeleted;
//
//    @ManyToOne
//    Ward ward;
//}
