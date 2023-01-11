package com.blas.jpa;

import com.blas.jpa.entity.Cliente;
import com.blas.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager entityManager= JpaUtil.getEntityManagerFactory();
            //EN EL QUERY SE CONSIDERA la clase Entity "Cliente" no la tabla de la bd
            String query ="select c from Cliente c";
           List<Cliente> lista= entityManager.createQuery(query,Cliente.class).getResultList();
           lista.forEach(System.out::println);
           entityManager.close();
    }
}
