package com.example.apollo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.apollo.models.Brand;
import com.example.apollo.services.BrandsService;
import com.example.apollo.utils.CustomResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/brands")
public class BrandController {

    @Autowired
    private BrandsService service;

    @GetMapping("/index")
    public List<Brand> index() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Brand create(@RequestBody Brand brand) {
        Brand result = service.insert(brand);
        try {
            service.save(result);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return result;
    }

    @PutMapping("/update")
    public Brand update(@RequestBody Brand brand) {
        return service.save(brand);
    }

    @DeleteMapping("")
    public CustomResponse delete(@RequestParam("id") String id) {
        service.delete(id);
        return new CustomResponse("Item successful deleted");

    }

}
