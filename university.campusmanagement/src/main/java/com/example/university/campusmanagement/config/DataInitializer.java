package com.example.university.campusmanagement.config;

import com.example.university.campusmanagement.model.Campus;
import com.example.university.campusmanagement.repository.CampusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CampusRepository campusRepository;

    public DataInitializer(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo inicializar datos si la colección está vacía
        if (campusRepository.count() == 0) {
            initializeSampleData();
        }
    }

    private void initializeSampleData() {
        List<Campus> sedes = Arrays.asList(
                createCampus("Sede Principal", "Av Bolívar #1-189 - Armenia, Quindío", "Armenia", "315 392 1662"),
                createCampus("Sede Anova", "Cra. 13 N° 15 Norte- 46 Ed. Anova", "Armenia", "310 804 9716"),
                createCampus("Casa Anova", "Calle 10N #13-09", "Armenia", "310 804 9716"),
                createCampus("Sede Alcázar", "Calle 4 Norte # 13- 05", "Armenia", "316 259 0798"),
                createCampus("Sede Nogal", "Carrera 13 #16N-07", "Armenia", "310 804 9819")
        );

        campusRepository.saveAll(sedes);
        System.out.println("✅ Datos de sedes inicializados correctamente: " + sedes.size() + " sedes creadas");
    }

    private Campus createCampus(String name, String address, String city, String telephone) {
        Campus campus = new Campus();
        campus.setName(name);
        campus.setAddress(address);
        campus.setCity(city);
        campus.setTelephone(telephone);
        campus.setActive(true);
        return campus;
    }
}