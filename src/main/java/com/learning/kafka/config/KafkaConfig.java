package com.learning.kafka.config;

import com.learning.kafka.constants.KafkaConstants;
import com.learning.kafka.dto.KafkaMessage;
import com.learning.kafka.exception.NotRetryException;
import com.learning.kafka.exception.RetryException;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {


    @Bean
    public ProducerFactory<String, KafkaMessage> createProducer(){
        return new DefaultKafkaProducerFactory<String,KafkaMessage>(getProducerConfig());
    }

    @Bean
    public KafkaTemplate<String,KafkaMessage> createKafkaTemplate(){
        return new KafkaTemplate<>(createProducer());
    }

    private Map<String, Object> getProducerConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092,localhost:29093,localhost:29094");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        map.put(ProducerConfig.RETRIES_CONFIG,"10");
        map.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        map.put(ProducerConfig.ACKS_CONFIG,"all");
        map.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,5);
        return map;
    }
    private Map<String, Object> getConsumerConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092,localhost:29093,localhost:29094");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        map.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        map.put(ConsumerConfig.GROUP_ID_CONFIG,"consumer-group-1");
        return map;
    }

    @Bean
    NewTopic createTopic(){
        return TopicBuilder
                .name(KafkaConstants.KAFKA_TOPIC)
                .partitions(3)
                .replicas(3)
                .configs(Map.of("min.insync.replicas","2"))
                .build();
    }

    @Bean
    public ConsumerFactory<String,Object> createConsumer(){
        return new DefaultKafkaConsumerFactory<>(getConsumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Object> createContainerFactory(ConsumerFactory<String,Object> consumerFactory,KafkaTemplate<String,Object> kafkaTemplate){

        DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate),new FixedBackOff(5000,3));
        defaultErrorHandler.addNotRetryableExceptions(NotRetryException.class);
        defaultErrorHandler.addRetryableExceptions(RetryException.class);
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(defaultErrorHandler);
        return factory;
    }

    @Bean
    public ProducerFactory<String,Object> creaateProducerFactory(){
        Map<String,Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092,localhost:29093,localhost:29094");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(map);
    }

    @Bean
    public KafkaTemplate<String,Object> createKafkaTemplateForDLT(ProducerFactory<String,Object> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }
}
