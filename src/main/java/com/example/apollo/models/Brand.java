package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Brand extends BaseModel {

    public Brand(String name) {
        this.brandName = name;
    }

    public Brand() {
    }

    @NotBlank
    String brandName;

}
