package com.foodygo.notification.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShippingConsumer {

    @KafkaListener(topics = "shipping", groupId = "notification-service")
    public void listen(String message) {
        log.info("Received Message: {}", message);
    }
}
