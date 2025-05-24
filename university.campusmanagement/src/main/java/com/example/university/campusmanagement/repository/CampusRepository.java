package com.example.university.campusmanagement.repository;

import com.example.university.campusmanagement.model.Campus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampusRepository extends MongoRepository<Campus, String> {
}
