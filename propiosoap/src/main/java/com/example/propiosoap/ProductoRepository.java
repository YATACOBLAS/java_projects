package com.example.propiosoap;

import com.blas.gen.Producto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductoRepository {

    private static final Map<String, Producto> lista= new HashMap<>();

    @PostConstruct
    public void initData(){
    }

    public Producto findProducto(String name){
       return lista.get(name);
    }

}
