package com.example.kafkademo.controller;

import com.example.kafkademo.model.User;
import com.example.kafkademo.service.ProducerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/user")
    public void sendUser(@RequestBody User user){
        log.info("-----------------------Start--------------------------");
        log.info("Get user information from controller side :: {}", user);
        producerService.sendMessage(user);
        log.info("-----------------------End--------------------------");
    }
}
