package com.trabajo.taller_repaso.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class costumerRepository {

    private final List<costumer> costumer = new ArrayList<>();

    public costumerRepository (){
        costumer.add(new costumer(1, "Jaime", "Barrera", "jaenba10@gmail.com"));
        costumer.add(new costumer(2, "Lucía", "Gómez", "lucia.gomez@gmail.com"));
        costumer.add(new costumer(3, "Carlos", "Ramírez", "carlos.ramirez@gmail.com"));
        costumer.add(new costumer(4, "María", "Fernández", "maria.fernandez@gmail.com"));
        costumer.add(new costumer(5, "Andrés", "Pérez", "andres.perez@gmail.com"));
        costumer.add(new costumer(6, "Valentina", "Martínez", "valen.martinez@gmail.com"));
        costumer.add(new costumer(7, "Diego", "López", "diego.lopez@gmail.com"));
        costumer.add(new costumer(8, "Sofía", "Díaz", "sofia.diaz@gmail.com"));
        costumer.add(new costumer(9, "Mateo", "Gutiérrez", "mateo.gutierrez@gmail.com"));
        costumer.add(new costumer(10, "Camila", "Rojas", "camila.rojas@gmail.com"));
        costumer.add(new costumer(11, "Julián", "Sánchez", "julian.sanchez@gmail.com"));
        costumer.add(new costumer(12, "Isabella", "Cano", "isa.cano@gmail.com"));
        costumer.add(new costumer(13, "Tomás", "Moreno", "tomas.moreno@gmail.com"));
        costumer.add(new costumer(14, "Laura", "Vargas", "laura.vargas@gmail.com"));
        costumer.add(new costumer(15, "Samuel", "Castro", "samuel.castro@gmail.com"));
        costumer.add(new costumer(16, "Antonella", "Navarro", "antonella.n@gmail.com"));
        costumer.add(new costumer(17, "Sebastián", "Reyes", "seb.reyes@gmail.com"));
        costumer.add(new costumer(18, "Manuela", "Mendoza", "manuela.mendoza@gmail.com"));
        costumer.add(new costumer(19, "Nicolás", "Ortega", "nicolas.ortega@gmail.com"));
        costumer.add(new costumer(20, "Paula", "Silva", "paula.silva@gmail.com"));
    }

    public List<costumer> findAll() { 
        return costumer; 
    }
}
