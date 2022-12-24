package com.example.springbootkafkatest;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/v1/messages")
@RequestMapping("/kafka")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("publish/{message}")
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("erfancode", request.message());
    }
}
