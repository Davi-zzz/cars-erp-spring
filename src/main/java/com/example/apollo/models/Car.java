package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Car extends BaseModel {

    public Car(String id, String timestamp, String color, Fuel fuel, int year, int ports,
            Model model) {
        this.id = id;
        this.timestamp = timestamp;
        this.color = color;
        this.fuel = fuel;
        this.year = year;
        this.ports = ports;
        this.model = model;
    }

    public Car() {

    }

    String timestamp;
    String color;
    Fuel fuel;
    int year;
    int ports;
    Model model;

}
