package com.example.university.campusmanagement.service;

import java.util.List;

public interface CrudService {
    Object create(Object entity);
    Object update(String id, Object entity);
    Object findById(String id);
    void delete(String id);
    List<Object> findAll();
}
