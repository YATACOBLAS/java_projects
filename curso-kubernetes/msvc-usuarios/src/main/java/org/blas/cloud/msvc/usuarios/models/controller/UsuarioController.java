package org.blas.cloud.msvc.usuarios.models.controller;

import org.blas.cloud.msvc.usuarios.models.entity.Usuario;
import org.blas.cloud.msvc.usuarios.models.services.UsuarioService;
import org.blas.cloud.msvc.usuarios.models.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/")
    public List<Usuario> listar(){
        return service.listar();
    }

    



}
