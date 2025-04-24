package com.trabajo.taller_repaso.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.taller_repaso.domain.costumer;
import com.trabajo.taller_repaso.domain.costumerRepository;


@RestController
@RequestMapping("/api")
public class CostumerController {

    private final costumerRepository repo;

    public CostumerController(costumerRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/costumers")
    public List<costumer> getCostumers(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String email,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size
    ) {
        return repo.findAll().stream()
            .filter(c -> firstName == null || c.getFirstName().equalsIgnoreCase(firstName))
            .filter(c -> lastName == null || c.getLastName().equalsIgnoreCase(lastName))
            .filter(c -> email == null || c.getEmail().equalsIgnoreCase(email))
            .skip((long) page * size)
            .limit(size)
            .toList();
    }

    @GetMapping("/costumers/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String email
    ) {
        List<costumer> filtered = repo.findAll().stream()
            .filter(c -> firstName == null || c.getFirstName().equalsIgnoreCase(firstName))
            .filter(c -> email == null || c.getEmail().equalsIgnoreCase(email))
            .toList();

        return Map.of(
            "Total de clientes", (double) filtered.size()
        );
    }
}


/**
* EJEMPLOS DE USO
* /api/costumers ---------- devuelve todos los costumers
* /api/costumers?firstName=Laura ---------- devuelve por nombre exacto
* /api/costumers?lastName=Moreno -------- devuelve por apellido exacto
* /api/costumers?email=jaenba10@gmail.com ------- devuelve por correo exacto
* /api/costumers?page=1&size=5 --------- devuelve del 6 al 10 costumer
* /api/costumers/stats ------------- devuelve numero total de costumers
*/


