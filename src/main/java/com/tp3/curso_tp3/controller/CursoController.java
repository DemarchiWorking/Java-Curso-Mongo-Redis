package com.tp3.curso_tp3.controller;

import com.tp3.curso_tp3.model.Aluno;
import com.tp3.curso_tp3.model.Curso;
import com.tp3.curso_tp3.service.AlunoService;
import com.tp3.curso_tp3.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    @GetMapping()
    public List<Curso> getAlunos() {
        return cursoService.findAll();

    }
    @GetMapping("{id}")
    public Optional<Curso> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);

    }
    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.cursoService.excluirCurso(id);
    }
    @PutMapping("{id}")
    public Curso update(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.atualizarCurso(id, curso);
    }
}

