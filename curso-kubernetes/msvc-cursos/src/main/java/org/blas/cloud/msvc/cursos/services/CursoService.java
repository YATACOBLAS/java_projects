package org.blas.cloud.msvc.cursos.models.services;

import org.blas.cloud.msvc.cursos.models.entity.Curso;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();
    Optional<Curso> porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);

}
