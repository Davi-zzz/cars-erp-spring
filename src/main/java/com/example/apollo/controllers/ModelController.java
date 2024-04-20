package com.example.apollo.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apollo.models.Brand;
import com.example.apollo.models.Model;
import com.example.apollo.repository.BrandRepository;
import com.example.apollo.services.ModelService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping(path = "/models")
public class ModelController extends BaseController<Model> {

    @Autowired
    private ModelService service;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    @PostMapping("/create")
    public Model create(@Valid Model entity) throws BadRequestException {
        return service.insertModel(entity);

    }

    @Override
    @PutMapping("/update")
    public Model update(@Valid Model entity) throws BadRequestException {
        Optional<Brand> brand = brandRepository.findById(entity.getBrandId());
        if (brand.isPresent()) {
            List<Model> models = brand.get().getModels();
            for (int i = 0; i < models.size(); i++) {
                if (models.get(i).equalsIds(entity)) {
                    models.set(i, entity);
                    service.save(entity);
                    return super.update(entity);
                }
            }
            throw new BadRequestException("Model not found");
        }
        throw new BadRequestException("Brand doesnt exist");
    }

}
