package com.tp3.curso_tp3.controller;

import com.tp3.curso_tp3.model.Curso;
import com.tp3.curso_tp3.model.MaterialDidatico;
import com.tp3.curso_tp3.service.CursoService;
import com.tp3.curso_tp3.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("material")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService materialService;

        @GetMapping()
    public List<MaterialDidatico> getMateriais() {
        return materialService.findAll();

    }

    @PostMapping
    public MaterialDidatico create(@RequestBody MaterialDidatico material) {
        return materialService.save(material);
    }
}
