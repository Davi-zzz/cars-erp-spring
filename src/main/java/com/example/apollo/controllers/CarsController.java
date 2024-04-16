package com.example.apollo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Cars;
import com.example.apollo.models.Fuel;
import com.example.apollo.models.Model;
import com.example.apollo.services.CarsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping(path = "/cars")
public class CarsController {

    @Autowired
    private final CarsService service;

    public CarsController(CarsService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public List<Cars> index() {
        return service.findAll();
    }

    @GetMapping("")
    public Cars getById(@RequestParam(value = "id") String id) {
        Model model = new Model();

        return new Cars(id, new Date().toString(), "blue", Fuel.fromValue(2), 2023, 4, model);
    }
}
