package com.example.demo.repository;
import com.example.demo.model.Color;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColorRepository extends MongoRepository<Color, String> {
    Color findByColorValue(String colorValue);
}