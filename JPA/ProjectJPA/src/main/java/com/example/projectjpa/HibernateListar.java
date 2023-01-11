package com.example.projectjpa;

import com.example.projectjpa.entity.Cliente;
import com.example.projectjpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {

        EntityManager entityManager= JpaUtil.getEntityManagerFactory();
            String query ="select c from Cliente c";
            List<Cliente> lista= entityManager.createQuery(query, Cliente.class).getResultList();
            lista.forEach(System.out::println);
            entityManager.close();
    }
}
