package com.example.university.campusmanagement.factory;

import com.example.university.campusmanagement.service.CampusService;
import com.example.university.campusmanagement.service.CrudService;
import org.springframework.stereotype.Component;

@Component
public class CampusCrudFactory implements CrudFactory {
    private final CampusService campusService;

    public CampusCrudFactory(CampusService campusService) {
        this.campusService = campusService;
    }

    @Override
    public CrudService createCrudService() {
        return campusService;
    }
}
