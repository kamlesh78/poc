package com.learning.kafka.service.impl;

import com.learning.kafka.constants.KafkaConstants;
import com.learning.kafka.dto.KafkaMessage;
import com.learning.kafka.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private KafkaTemplate<String,KafkaMessage> kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishEvent(KafkaMessage kafkaMessage) {
        CompletableFuture<SendResult<String, KafkaMessage>> result = kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, "test", kafkaMessage);
        result.whenComplete((res,exception)->{
            if(exception != null){
                log.error("Exeption in publishEvent");
            }else {
                log.info("Message published");
            }
        });
        result.join();
    }
}
