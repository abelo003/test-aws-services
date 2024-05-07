package com.example.testawsservices.components;

import com.example.testawsservices.service.KafkaTestMessagingService;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestCustomActuatorInfoContributor implements InfoContributor {

    private KafkaTestMessagingService kafkaTestMessagingService;

    public TestCustomActuatorInfoContributor(KafkaTestMessagingService kafkaTestMessagingService) {
        this.kafkaTestMessagingService = kafkaTestMessagingService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        long tacoCount = kafkaTestMessagingService.getSentMessagesCounter();
        Map<String, Object> tacoMap = new HashMap<String, Object>();
        tacoMap.put("count", tacoCount);
        builder.withDetail("test-custom-stats", tacoMap);
    }
}
