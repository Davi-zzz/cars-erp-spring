package com.example.apollo.models;

import lombok.Data;

public @Data class Cars {
    String id;
    String timestamp;
    String color;
    int fuel;
    int year;
    int ports;
    Model model;

}
