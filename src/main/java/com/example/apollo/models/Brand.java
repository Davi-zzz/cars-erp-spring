package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;

import com.example.apollo.utils.annotations.UUID;

import lombok.Data;

@JsonComponent
public @Data class Brand {

    @UUID
    String id;
    String brandName;

}
