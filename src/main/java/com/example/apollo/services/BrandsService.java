package com.example.apollo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apollo.models.Brand;
import com.example.apollo.repository.BrandsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository repository;

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public Brand insert(Brand brand) {
        return repository.insert(brand);
    }

    public Brand save(Brand result) {
        return repository.save(result);
    }

    public void delete(String id) {
        try {
            repository.deleteById(id);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Optional<Brand> findById(String id) {
        return repository.findById(id);
    }

}
