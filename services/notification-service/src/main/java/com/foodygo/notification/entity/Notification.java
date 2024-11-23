package com.foodygo.notification.entity;


import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "Notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Notification {

    @Id
    Integer id;

    @Builder.Default
    Instant timestamp = Instant.now();

    String message;

    String type;

    Map<String, String> data;
}
