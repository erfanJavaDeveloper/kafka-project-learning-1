package com.example.springbootkafkatest.dao;

import com.example.springbootkafkatest.entity.Erfan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoSender extends MongoRepository<Erfan, Long> {
}
