package com.blas.jpa;

import com.blas.jpa.entity.Cliente;
import com.blas.jpa.services.ClienteService;
import com.blas.jpa.services.ClienteServiceImpl;
import com.blas.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import org.hibernate.event.spi.ClearEvent;

import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {
        System.out.println("==========Listar============");
        EntityManager entityManager = JpaUtil.getEntityManagerFactory();
        ClienteService service= new ClienteServiceImpl(entityManager);
        service.listar().forEach(e-> e.toString());
        System.out.println("==========PorId============");
        Optional<Cliente> c =service.porId(2L);
        c.ifPresent(System.out::println);
        System.out.println("==========Guardar============");
        Cliente cliente = new Cliente();
        cliente.setNombre("Julian");
        cliente.setApellido("Didan");
        cliente.setFormaPago("debito");
        service.guardar(cliente);
        System.out.println("GUARDADO CON EXITO !!!");
        System.out.println("==========Editar============");
        System.out.println("mI id es"+cliente.getId());
        Long id= cliente.getId();
        Optional<Cliente> op=service.porId(id);
            op.ifPresent( e-> {
                e.setFormaPago("paypal");
                service.guardar(e);
                System.out.println("Editado!!!");
                service.listar().forEach(System.out::println);
            });
        System.out.println("==========Eliminar============");
          service.eliminar(cliente);
        System.out.println("Eliminado");
        service.listar().forEach(a->a.toString());
    }
}
