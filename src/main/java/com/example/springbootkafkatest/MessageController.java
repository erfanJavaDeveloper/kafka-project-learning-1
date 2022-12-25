package com.example.springbootkafkatest;

import com.example.springbootkafkatest.dto.StudentDto;
import com.example.springbootkafkatest.service.ServiceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class MessageController {
    @Autowired
    private ServiceSender serviceSender;

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("publish")
    public void publish(@RequestBody StudentDto student) {
        kafkaTemplate.send("erfanCode", student.getName());
        serviceSender.save(student);
    }
}
