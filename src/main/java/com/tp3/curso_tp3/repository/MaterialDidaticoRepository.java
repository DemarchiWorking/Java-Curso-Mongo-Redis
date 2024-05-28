package com.tp3.curso_tp3.repository;

import com.tp3.curso_tp3.model.MaterialDidatico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {
}
