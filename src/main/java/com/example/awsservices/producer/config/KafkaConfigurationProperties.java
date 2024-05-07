package com.example.testawsservices.producer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "service.kafka.configuration")
public class KafkaConfigurationProperties {

    private String kafkaListenerId;
    private String kafkaGroupId;
    private String kafkaTopics;

}
