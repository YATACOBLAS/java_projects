package org.blas.cloud.msvc.cursos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoUsuario> cursoUsuarios;

    public Curso() {
        this.cursoUsuarios = new ArrayList<>();
    }

    public void addCursoUsuario( CursoUsuario cu){
        this.cursoUsuarios.add(cu);
    }
    public void deleteCursoUsuario(CursoUsuario cu){
    //    this.cursoUsuarios = this.cursoUsuarios.stream().filter(a-> {return a.getUsuarioId() != cu.getUsuarioId();}).collect(Collectors.toList());
        cursoUsuarios.remove(cu);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<CursoUsuario> getCursoUsuarios() {
        return cursoUsuarios;
    }

    public void setCursoUsuarios(List<CursoUsuario> cursoUsuarios) {
        this.cursoUsuarios = cursoUsuarios;
    }
}
