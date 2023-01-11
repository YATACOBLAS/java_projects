package com.blas.jpa;

import com.blas.jpa.entity.ClienteDTO;
import com.blas.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import javafx.beans.binding.ObjectExpression;

import java.util.List;

public class HibernateQL {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManagerFactory();

        System.out.println("============List<Object>==========");
        List<Object[]> registros = entityManager.createQuery("select c.id, c.nombre,c.apellido from Cliente c",Object[].class).getResultList();
        registros.forEach(a->{
            Long id= (Long) a[0];
            String nombre= (String) a[1];
            String apellido= (String) a[2];
            System.out.println(" id="+id+", nombre="+nombre+", apellido="+apellido);
        });

        System.out.println("============Object[]==========");
        Object[] columnas=entityManager.createQuery("select c.id, c.nombre,c.apellido from Cliente c where c.id=:id",Object[].class)
                .setParameter("id",2L)
                .getSingleResult();
        System.out.println(" id="+columnas[0]+", nombre="+columnas[1]+", apellido="+columnas[2]);

        System.out.println("============STRING==========");
        String nombre = entityManager.createQuery("select c.nombre from Cliente c where c.id=:id",String.class).setParameter("id",4L)
                .getSingleResult();
        System.out.println("Nombre unico: "+ nombre);

        System.out.println("============CLASE PERSONALIZADA==========");
        List<ClienteDTO> listadto = entityManager.createQuery("select new com.blas.jpa.entity.ClienteDTO(c.nombre,c.apellido) from Cliente c",ClienteDTO.class)
                .getResultList();
        listadto.forEach(System.out::println);
        System.out.println("============Consultas con funciones de agregaciones ==========");
        columnas = entityManager.createQuery("select min(c.id), max(c.id), count(c.id),sum(c.id), avg(c.id)  from Cliente c",Object[].class)
                .getSingleResult();
        System.out.println(" min="+columnas[0]+", max="+columnas[1]+", count="+columnas[2]+", suma="+columnas[3]+", promedio="+columnas[4]);

        //siempre cerrar conexion
        entityManager.close();
    }
}
