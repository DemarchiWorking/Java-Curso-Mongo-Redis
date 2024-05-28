package com.tp3.curso_tp3.repository;

import com.tp3.curso_tp3.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
