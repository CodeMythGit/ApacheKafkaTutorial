package com.example.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaUiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaUiExampleApplication.class, args);
    }

}
