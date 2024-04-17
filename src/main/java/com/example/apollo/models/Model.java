package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Model extends BaseModel {

    public Model(Brand brand, String name, float fipeValue) {
        this.brand = brand;
        this.name = name;
        this.fipeValue = fipeValue;
    }

    public Model() {

    }

    Brand brand;
    String name;
    float fipeValue;

}
