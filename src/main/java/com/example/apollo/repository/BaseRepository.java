package com.example.apollo.repository;

import static com.example.apollo.utils.Tools.newUUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.apollo.models.BaseModel;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends MongoRepository<T, String> {

    @Override
    default <S extends T> S insert(S entity) {
        entity.setId(newUUID());
        return entity;
    }

}
