package com.example.apollo.models;

import java.util.*;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Car extends BaseModel {

    public Car(String id, String timestamp, String color, Fuel fuel, int year, int ports, Brand brand,
            List<Model> models) {
        this.timestamp = timestamp;
        this.color = color;
        this.fuel = fuel;
        this.year = year;
        this.ports = ports;
        this.brand = brand;
        this.models = new ArrayList<>();
        this.id = id;
    }

    public Car() {

    }

    String timestamp;
    String color;
    Fuel fuel;
    int year;
    int ports;
    @DBRef
    Brand brand;
    List<Model> models;

    public void addModel(Model model) {
        this.models.add(model);
    }

}
