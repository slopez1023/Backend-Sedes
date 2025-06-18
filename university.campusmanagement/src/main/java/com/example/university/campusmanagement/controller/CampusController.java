package com.example.university.campusmanagement.controller;

import com.example.university.campusmanagement.factory.CrudFactory;
import com.example.university.campusmanagement.model.Campus;
import com.example.university.campusmanagement.service.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campuses")
@CrossOrigin(origins = "http://localhost:3000")
public class CampusController {
    private final CrudService crudService;

    public CampusController(CrudFactory crudFactory) {
        this.crudService = crudFactory.createCrudService();
    }

    @PostMapping
    public ResponseEntity<Object> createCampus(@RequestBody Campus campus) {
        try {
            Object createdCampus = crudService.create(campus);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating campus: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCampus(@PathVariable String id, @RequestBody Campus campus) {
        try {
            Object updatedCampus = crudService.update(id, campus);
            return ResponseEntity.ok(updatedCampus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campus not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating campus: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCampus(@PathVariable String id) {
        try {
            Object campus = crudService.findById(id);
            return ResponseEntity.ok(campus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campus not found: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> disableCampus(@PathVariable String id) {
        try {
            crudService.delete(id);
            return ResponseEntity.ok("Campus disabled successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campus not found: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAllCampuses() {
        try {
            List<Object> campuses = crudService.findAll();
            return ResponseEntity.ok(campuses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}