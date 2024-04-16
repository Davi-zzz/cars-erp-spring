package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.apollo.utils.annotations.UUID;

import lombok.Data;

@JsonComponent
@Document
public @Data class Cars {

    public Cars(String id, String timestamp, String color, Fuel fuel, int year, int ports,
            Model model) {
        this.id = id;
        this.timestamp = timestamp;
        this.color = color;
        this.fuel = fuel;
        this.year = year;
        this.ports = ports;
        this.model = model;
    }

    public Cars() {

    }

    @UUID
    String id;
    String timestamp;
    String color;
    Fuel fuel;
    int year;
    int ports;
    Model model;

}
