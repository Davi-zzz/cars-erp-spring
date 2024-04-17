package com.example.apollo.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apollo.models.Car;

@Repository
public interface CarService extends MongoRepository<Car, String> {

}
