package com.example.university.campusmanagement.factory;

import com.example.university.campusmanagement.service.CrudService;

public interface CrudFactory {
    CrudService createCrudService();
}

//metodo createCrudService() actua como una fabrica abstracta para crear instancias de servicios CRUD
//Desde CampusController se llama esta fabrica en el constructor para obtener instancia de CrudService que
//y asi desacopla la creacion del servicio y permite intercambiar implementaciones
