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

    // TODO: refatorar a manipulacao de relacionamentos do projeto

    @Autowired
    private BrandRepository brandRepository;

    public Model insertModel(Model entity) throws BadRequestException {
        Optional<Brand> modelBrand = brandRepository.findById(entity.getBrandId());
        if (modelBrand.isPresent()) {
            super.insert(entity);
            Model savedModel = super.save(entity);
            modelBrand.get().addModel(savedModel);
            brandRepository.save(modelBrand.get());
            return savedModel;
        }
        throw new BadRequestException("Brand not found");
    }

    @Override
    public void delete(String id) throws BadRequestException {
        // TODO Auto-generated method stub
        Optional<Model> model = super.findById(id);
        if (model.isPresent()) {
            Optional<Brand> brand = brandRepository.findById(model.get().getBrandId());
            if (brand.isPresent() && brand.get().getModels().remove(model.get())) {

                brandRepository.save(brand.get());

            }
        }
        super.delete(id);
    }

}
