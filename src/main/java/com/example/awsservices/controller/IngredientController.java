package com.example.testawsservices.controller;

import com.example.testawsservices.service.KafkaTestMessagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/api/ingredients", produces="application/json") @CrossOrigin(origins="http://localhost:8080")
public class IngredientController {

    private final KafkaTestMessagingService kafkaTestMessagingService;

    public IngredientController(KafkaTestMessagingService kafkaTestMessagingService) {
        this.kafkaTestMessagingService = kafkaTestMessagingService;
    }

    @GetMapping(params = "msg")
    public String sendKafkaMessage(String msg) {
        log.info("Sending Message to Kafka {}", msg);
        kafkaTestMessagingService.senMessage(msg);
        return "Sending Message to Kafka: " + msg;
    }

    @GetMapping
    public List<String> allIngredients() {
        log.info("Getting it.");
        return Arrays.asList("ok", "ok", "ok");
    }
    @PostMapping
    //@PreAuthorize("#{hasRole('ADMIN')}")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveIngredient(@RequestBody String ingredient) {
        log.info("Save it.");
        return "Ok";
    }
    @DeleteMapping("/{id}")
    //@PreAuthorize("#{hasRole('ADMIN')}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable("id") String ingredientId) {
        log.info("Delete it.");
    }


}
