package com.example.apollo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Brand;
import com.example.apollo.models.Car;
import com.example.apollo.models.Fuel;
import com.example.apollo.models.Model;
import com.example.apollo.services.CarService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public List<Car> index() {
        return service.findAll();
    }

    @GetMapping("")
    public Car getById(@RequestParam(value = "id") String id) {
        Model model = new Model(new Brand(), "asdasd", 10293);

        return new Car(id, new Date().toString(), "blue", Fuel.fromValue(2), 2023, 4, model);
    }
}
