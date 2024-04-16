package com.example.apollo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import static com.example.apollo.utils.Tools.newUUID;
import com.example.apollo.models.Brand;

@Repository
public interface BrandsRepository extends MongoRepository<Brand, String> {

    @Override
    default <S extends Brand> S insert(S entity) {
        entity.setId(newUUID());
        return entity;
    }

}
