package com.tp3.curso_tp3.service;

import com.tp3.curso_tp3.model.Aluno;
import com.tp3.curso_tp3.model.Curso;
import com.tp3.curso_tp3.repository.AlunoRepository;
import com.tp3.curso_tp3.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Cacheable(value="curso")
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);

    }
    @Cacheable(value="curso")
    public Optional<Curso> buscarPorId(@PathVariable Long id) {
        return cursoRepository.findById(id);
    }
    @Cacheable(value = "curso", key="#id")
    public void excluirCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        this.cursoRepository.delete(curso);
    }
    @Cacheable(value = "curso", key="#id")
    public Curso atualizarCurso(Long id, Curso cursoNovo) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNome(cursoNovo.getNome());
            curso.setTurma(cursoNovo.getTurma());
            curso.setProfessor(cursoNovo.getProfessor());
            return cursoRepository.save(curso);
        }).orElseGet(() -> {
            cursoNovo.setId(id);
            return cursoRepository.save(cursoNovo);
        });
    }
}

