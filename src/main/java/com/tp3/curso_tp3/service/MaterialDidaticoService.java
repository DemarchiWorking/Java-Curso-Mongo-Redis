package com.tp3.curso_tp3.service;

import com.tp3.curso_tp3.model.Curso;
import com.tp3.curso_tp3.model.MaterialDidatico;
import com.tp3.curso_tp3.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    @Cacheable(value="curso")
    public List<MaterialDidatico> findAll() {
        return materialDidaticoRepository.findAll();
    }

    public MaterialDidatico save(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);

    }

}
