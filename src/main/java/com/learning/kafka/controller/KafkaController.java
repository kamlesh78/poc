package com.learning.kafka.controller;

import com.learning.kafka.dto.KafkaMessage;
import com.learning.kafka.service.KafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public String createEvent(@RequestBody KafkaMessage kafkaMessage){
        kafkaService.publishEvent(kafkaMessage);
        return "successfully published event";
    }
}
