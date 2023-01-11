package com.blas.jpa;

import com.blas.jpa.entity.Cliente;
import com.blas.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEliminar {
    public static void main(String[] args) {

      EntityManager mn= JpaUtil.getEntityManagerFactory();
      try {
          Cliente c= mn.find(Cliente.class,1L);
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
