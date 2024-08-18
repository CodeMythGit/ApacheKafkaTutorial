package com.example.kafkademo.service;

import com.example.kafkademo.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ConsumerService {

    private final String TOPIC_NAME = "kafka-demo";

    private KafkaTemplate<String, User> kafkaTemplate;

    @KafkaListener(topics = TOPIC_NAME, groupId = "user-group")
    public void consumeMessage(User user) {
        log.info("Consume message from Kafka topic :: {}, and content is :: {}", TOPIC_NAME, user);
        kafkaTemplate.send("topic-demo-1", user);
    }
    @KafkaListener(topics = "topic-demo-1", groupId = "user-group")
    public void consumeMessage1(User user) {
        log.info("Consume message from Kafka topic :: {}, and content is :: {}", "topic-demo-1", user);
    }
}
