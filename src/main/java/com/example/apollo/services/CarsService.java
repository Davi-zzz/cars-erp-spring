package com.example.apollo.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apollo.models.Cars;

@Repository
public interface CarsService extends MongoRepository<Cars, String> {

}
