package com.example.projectjpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {


    private static final EntityManagerFactory entityManagerFactory=buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory(){
       return Persistence.createEntityManagerFactory("projectJPA");
    }
    public static  EntityManager getEntityManagerFactory(){
        return entityManagerFactory.createEntityManager();
    }
}
