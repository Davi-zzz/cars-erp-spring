package com.example.apollo.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class DatabaseConnection {

    @Value("${db.url}")
    String connecString;
    
    @Bean
    MongoClient mongoClient() {
        return MongoClients.create(connecString);
    }

    @Bean
    MongoOperations mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "cluster");
    }

}

class DatabaseConnectionError extends Error {
    public DatabaseConnectionError(String msg) {
        super(msg);
    }
}
