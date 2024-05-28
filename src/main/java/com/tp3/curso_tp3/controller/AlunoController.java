package com.tp3.curso_tp3.controller;

import com.tp3.curso_tp3.model.Aluno;
import com.tp3.curso_tp3.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping()
    public List<Aluno> getAlunos() {
        return alunoService.findAll();

    }
    @GetMapping("{id}")
    public Optional<Aluno> getAlunoById(@PathVariable Long id) {
        return alunoService.buscarPorId(id);

    }
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }
    @DeleteMapping("{id}")
    public void deleteAluno(@PathVariable Long id) {
        this.alunoService.excluirAluno(id);
    }
    @PutMapping("{id}")
    public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.atualizarAluno(id, aluno);
    }
}
