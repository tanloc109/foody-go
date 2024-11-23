package com.foodygo.notification.repository;

import com.foodygo.notification.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Integer> {
}
