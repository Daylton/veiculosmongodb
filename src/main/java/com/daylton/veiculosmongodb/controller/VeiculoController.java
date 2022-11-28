package com.daylton.veiculosmongodb.controller;

import com.daylton.veiculosmongodb.model.VeiculoModel;
import com.daylton.veiculosmongodb.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<VeiculoModel> findAll() {
        return veiculoService.findAll();
    }

    @GetMapping("/{id}")
    public VeiculoModel findById(@PathVariable("id") String id) {
        return veiculoService.findById(id);
    }

    @PostMapping
    public VeiculoModel create(@RequestBody VeiculoModel veiculoModel) {
        return veiculoService.create(veiculoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteVeiculo(@PathVariable("id") String id) {
        boolean deleted = false;
        deleted = veiculoService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel> update(@PathVariable("id") String id, @RequestBody VeiculoModel veiculoModel) {
        veiculoModel = veiculoService.update(id, veiculoModel);
        return ResponseEntity.ok(veiculoModel);
    }

}
