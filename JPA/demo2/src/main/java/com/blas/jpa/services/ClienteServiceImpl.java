package com.blas.jpa.services;

import com.blas.jpa.entity.Cliente;
import com.blas.jpa.repositories.ClienteRepository;
import com.blas.jpa.repositories.CrudRepository;
import com.sun.jmx.mbeanserver.Repository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService{

    EntityManager entityManager;
    CrudRepository<Cliente> repository;

    public ClienteServiceImpl(EntityManager em){
        this.entityManager=em;
        this.repository= new ClienteRepository(em);
    }

    @Override
    public List<Cliente> listar(){
        return repository.listar();
    }

    @Override
    public Optional<Cliente> porId(Long id) {

         return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Cliente cliente) {
        try {
             entityManager.getTransaction().begin();
             repository.guardar(cliente);
             entityManager.getTransaction().commit();
            }catch(Exception e){
             entityManager.getTransaction().rollback();
             e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Cliente cliente) {
        try {
            entityManager.getTransaction().begin();
            repository.eliminar(cliente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
