package com.trabajo.taller_repaso.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.trabajo.taller_repaso.domain.productRepository;
import com.trabajo.taller_repaso.domain.products;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class ProductController {

    private final productRepository repo;

    public ProductController(productRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<products> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size
    ) {
        return repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .skip((long) page * size)
            .limit(size)
            .toList();
    }

    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
        ) {
            List<products> filtered = repo.findAll().stream()
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .toList();

        DoubleSummaryStatistics statistics = filtered.stream()
            .mapToDouble(products::getPrice)
            .summaryStatistics();

        return Map.of(
            "Numero de productos", (double) statistics.getCount(),
            "Precio promedio", statistics.getAverage(),
            "Precio minimo", statistics.getMin(),
            "Precio maximo", statistics.getMax(),
            "Suma de precios", statistics.getSum()
        );
}

}


/**
 * EJEMPLOS DE USO
 * /api/products?minPrice=2000 ---- devuelve solo productos con precio desde 2000
 * /api/products ----- devuelve todos los productos
 * /api/products?category=Lácteo ------ devuelve solo productos de categoria Lácteo
 * /api/products?minPrice=1500&maxPrice=2500&category=Bebida --------- devuelve los productos con precio desde 1500 hasta 2500 de la categoria Bebida
 * /api/products?page=1&size=5 ----- devuelve los productos 6 al 10
 * /api/products?minPrice=3000&categoryBebida=&page=0&size=10 ----- devuelve los primeros 10 productos con precio desde de 3000 de la categoria Bebida
 * /api/products/stats -------- devuelve estadisticas de los productos
 * /api/products/stats?category=Bebida --------- devuelve estadisticas de la categoria Bebida de los productos
 */
