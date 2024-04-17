package com.example.apollo.services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import com.example.apollo.models.BaseModel;
import com.example.apollo.repository.BaseRepository;

public class BaseService<T extends BaseModel> {

    @Autowired
    private BaseRepository<T> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T insert(T entity) throws BadRequestException {
        return repository.insert(entity);
    }

    public T save(T result) {
        return repository.save(result);
    }

    public void delete(String id) {
        try {
            repository.deleteById(id);

        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

}
