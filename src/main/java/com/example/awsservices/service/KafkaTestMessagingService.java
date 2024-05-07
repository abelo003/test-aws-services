package com.example.testawsservices.service;

import com.example.testawsservices.producer.config.KafkaConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class KafkaTestMessagingService {

    private HashMap<String, Integer> counter = new HashMap<>();

    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaConfigurationProperties kafkaConfigurationProperties;
    @Autowired
    public KafkaTestMessagingService(KafkaTemplate<String, String> kafkaTemplate,
                                     KafkaConfigurationProperties kafkaConfigurationProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigurationProperties = kafkaConfigurationProperties;
    }

    public int getSentMessagesCounter() {
        return counter.getOrDefault("test.counter", 0);
    }

    public void senMessage(String message) {
        log.info("Sending message to kafka {}", message);
        kafkaTemplate.send(kafkaConfigurationProperties.getKafkaTopics(), message);
        counter.put("test.counter", counter.getOrDefault("test.counter", 0) + 1);
        //The same because we configure the default topic in yml configuration
        //kafkaTemplate.sendDefault(message);
    }

}
