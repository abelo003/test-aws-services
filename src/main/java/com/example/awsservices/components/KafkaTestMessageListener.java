package com.example.testawsservices.components;

import com.example.testawsservices.producer.config.KafkaConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaTestMessageListener {

    private final KafkaConfigurationProperties kafkaConfigurationProperties;

    /*@KafkaListener(topics="message.zeta.topic")
    public void handle(String message) {
        log.info("A message in receiving from kafka {}", message);
    }*/

    @KafkaListener(
            id = "#{kafkaConfigurationProperties.getKafkaListenerId()}",
            groupId = "#{kafkaConfigurationProperties.getKafkaGroupId()}",
            topics = "#{kafkaConfigurationProperties.getKafkaTopics()}"
    )
    public void handle(ConsumerRecord<String, String> record) {
        log.info("Received message from kafka and partition {} with timestamp {} value {}", record.partition(), record.timestamp(), record.value());
    }

    /*@KafkaListener(topics="message.zeta.topic")
    public void handle(String order, Message<Object> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Received from partition {} with timestamp {}",
                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID),
                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP));
        ui.displayOrder(order);
    }*/

}
