package com.blas.jpa.repositories;

import com.blas.jpa.entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente> {

    private EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    public List<Cliente> listar() {
        return entityManager.createQuery("select c from Cliente c",Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Long id) {

        return entityManager.find(Cliente.class,id);
    }

    @Override
    public void guardar(Cliente cliente) {
            if(cliente.getId()!=null && cliente.getId()>0){
                entityManager.merge(cliente);
            }else{
              entityManager.persist(cliente);
            }
    }

    @Override
    public void eliminar(Cliente cliente) {
               entityManager.remove(cliente);
    }
}
