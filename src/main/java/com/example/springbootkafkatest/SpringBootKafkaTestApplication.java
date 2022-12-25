package com.example.springbootkafkatest;

import com.example.springbootkafkatest.dao.DaoSender;
import com.example.springbootkafkatest.entity.Erfan;
import com.example.springbootkafkatest.service.ServiceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBootKafkaTestApplication {
    @Autowired
    private ServiceSender serviceSender;

    @Autowired
    private DaoSender daoSender;



    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaTestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String,String> kafkaTemplate){
        return args -> {
            Erfan erfan = new Erfan();
            erfan.setId(1L);
            erfan.setName("hello kafka");
            kafkaTemplate.send("erfanCode","hello kafka");
            Erfan save = daoSender.save(erfan);
            save.setName("olsjdfl");
        };
    }

}
