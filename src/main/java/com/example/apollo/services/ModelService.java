package com.example.apollo.services;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apollo.models.Brand;
import com.example.apollo.models.Model;
import com.example.apollo.repository.BrandRepository;

@Service
public class ModelService extends BaseService<Model> {

    @Autowired
    private BrandRepository brandRepository;

    private Boolean validateBrand(Brand brand) {
        if (brandRepository.findById(brand.getId()).isEmpty()) {
            return false;
        }
        return true;
    }

    private Boolean validateBrandFields(Brand brand) {
        Optional<Brand> comparison = brandRepository.findById(brand.getId());
        if (comparison.isPresent()) {
            Brand retrievedBrand = comparison.get();
            return retrievedBrand.equals(brand);
        }
        return true;
    }

    @Override
    public Model insert(Model model) throws BadRequestException {
        if (!validateBrand(model.getBrand())) {
            throw new BadRequestException("The brand informed does not exist");
        }
        return super.insert(model);
    }

    public Model update(Model model) throws BadRequestException {
        if (!validateBrandFields(model.getBrand())) {
            throw new BadRequestException("The brand informed does not exist or illegaly modified");
        }
        return super.save(model);
    }

}
