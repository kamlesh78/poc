package com.learning.kafka.service;

import com.learning.kafka.dto.KafkaMessage;

public interface KafkaService {
    void publishEvent(KafkaMessage kafkaMessage);
}
