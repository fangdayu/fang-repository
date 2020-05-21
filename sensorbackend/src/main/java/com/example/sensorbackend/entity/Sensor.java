package com.example.sensorbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String product_id;
    private String type;
    private String type_detail;
    private String input;
    private String output;
    private String using_environment;
    private String range;
    private String level;
    private String application;
    private String description;
    private String strength;
    private String more_detail;
}
