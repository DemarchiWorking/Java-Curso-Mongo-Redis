package com.tp3.curso_tp3.service;

import com.tp3.curso_tp3.model.Aluno;
import com.tp3.curso_tp3.model.Curso;
import com.tp3.curso_tp3.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Cacheable(value="aluno")
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);

    }
    @Cacheable(value="aluno")
    public Optional<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id);
    }
    @Cacheable(value = "alunos", key="#id")
    public void excluirAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        this.alunoRepository.delete(aluno);
    }

    @Cacheable(value = "aluno", key="#id")
    public Aluno atualizarAluno(Long id, Aluno alunoNovo) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(alunoNovo.getNome());
            aluno.setTelefone(alunoNovo.getTelefone());
            aluno.setEmail(alunoNovo.getEmail());
            aluno.setCpf(alunoNovo.getCpf());
            return alunoRepository.save(aluno);
        }).orElseGet(() -> {
            alunoNovo.setId(id);
            return alunoRepository.save(alunoNovo);
        });
    }
}
