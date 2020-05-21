package com.example.sensorbackend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;

    @Test
    void findAll() {
        System.out.println(sensorRepository.findAll());
    }
}