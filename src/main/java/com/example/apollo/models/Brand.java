package com.example.apollo.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Brand extends BaseModel {

    public Brand(String name) {
        this.name = name;
        this.models = new ArrayList<>();
    }

    public Brand() {
    }

    @NotBlank
    private String name;
    @DBRef
    private List<Model> models;

    public void addModel(Model model) {
        this.models.add(model);
    }

}
