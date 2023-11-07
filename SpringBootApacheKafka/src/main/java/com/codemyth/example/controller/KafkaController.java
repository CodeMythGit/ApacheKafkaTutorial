package com.codemyth.example.controller;

import com.codemyth.example.model.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/kafka")
@RestController
@AllArgsConstructor
@Slf4j
public class KafkaController {

    final KafkaTemplate kafkaTemplate;

    @PostMapping
    public String sentMessage(@RequestBody Account account) {
        this.kafkaTemplate.send("transaction-1", new Account(account.getHolder(), account.getFunds()));

        return "Hello World!";
    }

    @KafkaListener(topics = "transaction-1")
    public void listener(@Payload Account account, ConsumerRecord<String, Account> cr) {
        log.info("Topic [transaction-1] Received message from {} with {} PLN ", account.getHolder(), account.getFunds());
        log.info(cr.toString());
    }


}
