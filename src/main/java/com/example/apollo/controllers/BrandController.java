package com.example.apollo.controllers;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Brand;
import com.example.apollo.services.BrandService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/brands")
public class BrandController extends BaseController<Brand> {

    @Autowired
    private BrandService service;

    @PostMapping("/create")
    @Override
    public Brand create(@Valid @RequestBody Brand brand) throws BadRequestException {
        Brand result = service.insert(new Brand(brand.getName()));
        try {
            service.save(result);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
        return result;
    }

    @PutMapping("/update")
    @Override
    public Brand update(@Valid Brand entity) throws BadRequestException {

        Optional<Brand> reference = service.findById(entity.getId());
        if (reference.isPresent()) {
            if (reference.get().getModels().equals(entity.getModels())) {
                return service.save(entity);
            }
            throw new BadRequestException("Illegal modified fields: Models");
        }
        throw new BadRequestException("Brand ID doesnt exists");
    }

}
