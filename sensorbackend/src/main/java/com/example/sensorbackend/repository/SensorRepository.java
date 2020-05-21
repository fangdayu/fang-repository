package com.example.sensorbackend.repository;

import com.example.sensorbackend.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {
}
