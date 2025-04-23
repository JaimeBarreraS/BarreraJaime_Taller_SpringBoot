package com.trabajo.taller_repaso.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class productRepository {

    private final List<products> products = new ArrayList<>();

    public productRepository (){
        products.add(new products(1, "Gaseosa", "Bebida", 2500, 10));
        products.add(new products(2, "Agua", "Bebida", 1500, 20));
        products.add(new products(3, "Jugo de Naranja", "Bebida", 3000, 15));
        products.add(new products(4, "Cerveza", "Bebida", 3500, 12));
        products.add(new products(5, "Energizante", "Bebida", 4000, 8));
        products.add(new products(6, "Té Helado", "Bebida", 2800, 10));
        products.add(new products(7, "Café", "Bebida", 2000, 25));
        products.add(new products(8, "Leche", "Lácteo", 2300, 18));
        products.add(new products(9, "Yogur", "Lácteo", 2700, 14));
        products.add(new products(10, "Chocolate Caliente", "Bebida", 3200, 9));
        products.add(new products(11, "Limonada", "Bebida", 2900, 11));
        products.add(new products(12, "Smoothie", "Bebida", 4500, 6));
        products.add(new products(13, "Soda Italiana", "Bebida", 3700, 7));
        products.add(new products(14, "Malteada", "Bebida", 4800, 5));
        products.add(new products(15, "Agua con Gas", "Bebida", 1800, 16));
        products.add(new products(16, "Refresco", "Bebida", 2600, 13));
        products.add(new products(17, "Gaseosa Dietética", "Bebida", 2500, 10));
        products.add(new products(18, "Té Verde", "Bebida", 3000, 9));
        products.add(new products(19, "Kombucha", "Bebida", 5000, 4));
        products.add(new products(20, "Jugo de Mango", "Bebida", 3100, 10));

    }

    public List<products> findAll() { 
        return products; 
    }
    
}

