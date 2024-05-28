package com.tp3.curso_tp3.repository;

import com.tp3.curso_tp3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
