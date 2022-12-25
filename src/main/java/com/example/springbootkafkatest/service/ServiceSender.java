package com.example.springbootkafkatest.service;

import com.example.springbootkafkatest.dao.DaoSender;
import com.example.springbootkafkatest.dto.StudentDto;
import com.example.springbootkafkatest.entity.Erfan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSender {

    @Autowired
    private DaoSender daoSender;

    public String save(StudentDto studentDto){
        Erfan erfan = new Erfan();
        erfan.setId(erfan.getId());
        erfan.setName(studentDto.getName());
        daoSender.save(erfan);
        return "done";
    }

}
