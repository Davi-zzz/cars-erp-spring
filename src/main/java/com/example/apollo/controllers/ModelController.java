package com.example.apollo.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Model;
import com.example.apollo.services.ModelService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping(path = "/models")
public class ModelController extends BaseController<Model> {

    @Autowired
    private ModelService service;

    @Override
    @PutMapping("/update")
    public Model update(@Valid @RequestBody Model entity) throws BadRequestException {
        Model result = service.update(entity);
        
        return result;
    }
}
