package com.example.university.campusmanagement.service;

import com.example.university.campusmanagement.model.Campus;
import com.example.university.campusmanagement.repository.CampusRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CampusService implements CrudService {
    private final CampusRepository campusRepository;

    public CampusService(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    @Override
    public Object create(Object entity) {
        if (entity instanceof Campus campus) {
            return campusRepository.save(campus);
        }
        throw new IllegalArgumentException("Entity must be of type Campus");
    }

    @Override
    public List<Object> findAll() {
        return campusRepository.findAll().stream().map(campus -> (Object) campus).toList();
    }

    @Override
    public Object update(String id, Object entity) {
        if (entity instanceof Campus campus) {
            Campus existingCampus = campusRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Campus not found"));
            existingCampus.setName(campus.getName());
            existingCampus.setAddress(campus.getAddress());
            existingCampus.setActive(campus.isActive());
            return campusRepository.save(existingCampus);
        }
        throw new IllegalArgumentException("Entity must be of type Campus");
    }

    @Override
    public Object findById(String id) {
        return campusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campus not found"));
    }

    @Override
    public void delete(String id) {
        Campus campus = campusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campus not found"));
        campus.setActive(false);
        campusRepository.save(campus);
    }
}
