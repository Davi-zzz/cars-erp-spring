package com.example.apollo.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.example.apollo.models.Brand;
import com.example.apollo.models.Car;
import com.example.apollo.models.Model;
import com.example.apollo.repository.BrandRepository;
import com.example.apollo.repository.ModelRepository;

@Repository
public class CarService extends BaseService<Car> {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelRepository modelRepository;

    public Car update(Car entity) throws BadRequestException {
        Optional<Brand> brand = brandRepository.findById(entity.getBrand().getId());
        if (brand.isPresent()) {
            List<String> modelsIds = entity.getModels().stream().map(Model::getId).toList();
            List<Model> findedModels = modelRepository.findAllById(modelsIds);
            if (!findedModels.isEmpty() && findedModels.size() == entity.getModels().size()) {
                return super.save(entity);
            }
            throw new BadRequestException("Some Model was not found");
        }
        throw new BadRequestException("Brand not found");
    }
}
