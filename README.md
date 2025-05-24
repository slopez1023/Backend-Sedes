# API_backend_PNsedes
Miembros del equipo (Sebastian Castañeda, Karen Lopez, Santiago Cardona, Juan Camilo Arias)
Codigo desarrollado en el idioma Ingles

Configuracion de la base de datos en la nube (Mongo Atlas), crear un file en resources llamado application.yaml
En Mongo Atlas, el tipo de conexion del cluster debe ser mediante un driver
spring:
  data:
    mongodb:
      uri: mongodb+srv://Cluster-1:12345@cluster-1.efebpeb.mongodb.net/?retryWrites=true&w=majority&appName=Cluster-1
      database: university_db
  application:
    name: campus-management
server:
  port: 8080

  Consumo de API del backend mediante Postman
  
Metodo POST para crear un objeto JSON

 {
        "id": "1",
        "name": "Sede Principal",
        "address": "Avenida Bolivar N-183",
        "city": "Armenia",
        "telephone": "3248762045",
        "active": true
    },

Metodo GET para obtener la lista de sedes

http://localhost:8080/api/campuses o localhost:8080/api/campuses
