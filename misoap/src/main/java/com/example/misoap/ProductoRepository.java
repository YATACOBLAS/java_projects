package com.example.misoap;

import com.blas.gen.Producto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductoRepository {

    private static final Map<String, Producto> productos= new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    }

    public Producto findCountry(String name) {
        return productos.get(name);
    }
}