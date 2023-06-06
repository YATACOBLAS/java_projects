package org.blas.cloud.msvc.cursos.models.controller;

import org.blas.cloud.msvc.cursos.models.entity.Curso;
import org.blas.cloud.msvc.cursos.models.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CursoController {

    @Autowired
     private CursoService service;

    @GetMapping("/")
    public List<Curso> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> porId(@PathVariable Long id){
        Optional<Curso> curso= service.porId(id);
        if(curso.isPresent()){
            return ResponseEntity.ok(curso.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/")
    public ResponseEntity<?> guardar(@Valid @RequestBody Curso c, BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }
       return ResponseEntity.ok(service.guardar(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id,@Valid @RequestBody Curso curso,BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }

        Optional<Curso> cursoOptional= service.porId(id);
        if(cursoOptional.isPresent()){
            Curso c=cursoOptional.get();
            c.setNombre(curso.getNombre());
           ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(c));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> cursoOptional= service.porId(id);
        if(cursoOptional.isPresent()){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String,String> errores= new HashMap<>();
        result.getFieldErrors().forEach(err->{
            errores.put(err.getField(),"el campo"+err.getField()+" "+ err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
