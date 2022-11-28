package com.daylton.veiculosmongodb.service;

import com.daylton.veiculosmongodb.model.VeiculoModel;

import java.util.List;

public interface VeiculoService {

    public List<VeiculoModel> findAll();

    VeiculoModel findById(String id);

    VeiculoModel create(VeiculoModel veiculoModel);

    boolean delete(String id);

    VeiculoModel update(String id, VeiculoModel veiculoModel);
}
