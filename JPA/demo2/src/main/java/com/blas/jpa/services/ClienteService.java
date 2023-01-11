package com.blas.jpa.services;

import com.blas.jpa.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    void guardar(Cliente cliente);
    void eliminar(Cliente cliente);
}
