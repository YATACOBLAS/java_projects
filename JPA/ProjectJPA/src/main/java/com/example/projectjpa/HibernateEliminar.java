package com.example.projectjpa;

import com.example.projectjpa.entity.Cliente;
import com.example.projectjpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEliminar {
    public static void main(String[] args) {

      EntityManager mn= JpaUtil.getEntityManagerFactory();
      try {
          Cliente c= mn.find(Cliente.class,2L);
       mn.getTransaction().begin();
       mn.remove(c);
       mn.getTransaction().commit();
    }catch (Exception e){
        mn.getTransaction().rollback();
        e.printStackTrace();
    }finally {
        mn.close();
      }

    }
}
