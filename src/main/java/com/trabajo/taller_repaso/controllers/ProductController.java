package com.trabajo.taller_repaso.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.trabajo.taller_repaso.domain.productRepository;
import com.trabajo.taller_repaso.domain.products;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {

    private final productRepository repo;

    public ProductController(productRepository repo) { 
        this.repo = repo; 
    }

    @GetMapping("/products")
    public List<products> mostrar(
        @RequestParam(name = "name", defaultValue = "") String name) 
        {
        if (name.isEmpty()) {
            return repo.findAll();
        }

        return repo.findAll().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name)).toList();
    }

    
}
        
        


