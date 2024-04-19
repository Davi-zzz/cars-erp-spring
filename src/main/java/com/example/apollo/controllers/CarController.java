package com.example.apollo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Car;
import com.example.apollo.services.CarService;

import jakarta.validation.Valid;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@RestController()
@RequestMapping(path = "/cars")
public class CarController extends BaseController<Car> {

    @Autowired
    private CarService service;

    @Override
    @PostMapping("/create")
    public Car create(@Valid Car entity) throws BadRequestException {
        entity.setTimestamp(new Date().toString());
        return super.create(entity);
    }

    @Override
    public Car update(@Valid Car entity) throws BadRequestException {
        return service.update(entity);
    }
}
