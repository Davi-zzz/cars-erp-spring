package com.example.apollo.models;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonComponent
@Document
@EqualsAndHashCode(callSuper = false)
public @Data class Model extends BaseModel {

    public Model(String name, float fipeValue) {
        this.name = name;
        this.fipeValue = fipeValue;
    }

    public Model() {

    }

    private String brandId;
    private String name;
    private float fipeValue;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Model model = (Model) obj;
        return id.equals(model.getId()) && brandId.equals(model.getBrandId()) && name.equals(model.getName())
                && fipeValue == model.getFipeValue();

    }

    public boolean equalsIds(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Model model = (Model) obj;
        return id.equals(model.getId()) && brandId.equals(model.getBrandId());

    }

}
