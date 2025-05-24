package com.example.university.campusmanagement.controller;

import com.example.university.campusmanagement.factory.CrudFactory;
import com.example.university.campusmanagement.model.Campus;
import com.example.university.campusmanagement.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campuses")
public class CampusController {
    private final CrudService crudService;

    public CampusController(CrudFactory crudFactory) {
        this.crudService = crudFactory.createCrudService();
    }

    @PostMapping
    public Object createCampus(@RequestBody Campus campus) {
        return crudService.create(campus);
    }

    @PutMapping("/{id}")
    public Object updateCampus(@PathVariable String id, @RequestBody Campus campus) {
        return crudService.update(id, campus);
    }

    @GetMapping("/{id}")
    public Object getCampus(@PathVariable String id) {
        return crudService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void disableCampus(@PathVariable String id) {
        crudService.delete(id);
    }

    @GetMapping
    public List<Object> getAllCampuses() {
        return crudService.findAll();
    }
}

/*
API del backend
CampusController expone endpoints REST al usar notaciones
como @postMapping, @putMapping, @getMapping y @deleteMapping,
y de esa manera clientes externos puedan usar aplicaciones
postman para consumir la API de la aplicación.
* */
