package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;

import com.example.apollo.utils.annotations.UUID;

import lombok.Data;

@JsonComponent
public @Data class Model {

    @UUID
    String id;
    Brand brand;
    String name;
    float fipeValue;

}
