package com.example.apollo.controllers;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.apollo.models.BaseModel;
import com.example.apollo.services.BaseService;
import com.example.apollo.utils.CustomResponse;

import jakarta.validation.Valid;

import java.util.*;

public class BaseController<T extends BaseModel> {

    @Autowired
    private BaseService<T> service;

    @GetMapping("/index")
    public List<T> index() {
        return service.findAll();
    }

    @GetMapping("")
    public Optional<T> index(@RequestParam String id) {
        return service.findById(id);
    }

    @PostMapping("/create")
    public T create(@Valid @RequestBody T entity) throws BadRequestException {
        T result = service.insert(entity);
        try {
            service.save(result);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return result;
    }

    @PutMapping("/update")
    public T update(@Valid @RequestBody T entity) throws BadRequestException {
        return service.save(entity);
    }

    @DeleteMapping("")
    public CustomResponse delete(@RequestParam("id") String id) {
        service.delete(id);
        return new CustomResponse("Item successful deleted");

    }
}
