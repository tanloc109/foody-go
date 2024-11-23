package com.foodygo.notification.service;

import java.util.Map;

public interface NotificationService {
    void sendNotification(String topic, Map<String, String> data);
}
