package com.example.apollo.services;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apollo.models.Brand;
import com.example.apollo.repository.BrandRepository;

@Service
public class BrandService extends BaseService<Brand> {

    @Autowired
    private BrandRepository repository;

    @Override
    public void delete(String id) throws BadRequestException {
        Optional<Brand> brand = repository.findById(id);
        if (brand.isPresent() && !brand.get().getModels().isEmpty()) {
            throw new BadRequestException("There is Models Associated to this Brand");
        }
        repository.deleteById(id);
    }
}
