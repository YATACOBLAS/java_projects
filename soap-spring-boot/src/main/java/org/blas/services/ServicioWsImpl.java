package org.blas.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.blas.webapp.jaxws.models.Curso;


import java.util.Arrays;
import java.util.List;

//la anotacion sin aparametro publicaria todos los metodos de esta clase,
// pero apra que sean solo de la interfaz se coloca el nombre
//El Web service tambien son stateless pero a diferencia delos EJB no son transaccionales a nos er que
// le pongamos las anotaciones de @Stateless
@WebService(endpointInterface = "org.blas.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs{

    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimiendo el servicio web con instancia... "+  this);
         contador++;
        System.out.println("El contador es:: "+contador);
        return "Hola como estas ?... "+persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("Lenguaje"),new Curso("Literatura"),new Curso("Arte"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito... "+curso.getNombre());
        Curso nuevoCurso= new Curso();
        nuevoCurso.setNombre("Matematica");
        return nuevoCurso;
    }
}
