package com.daylton.veiculosmongodb.service;

import com.daylton.veiculosmongodb.model.VeiculoModel;
import com.daylton.veiculosmongodb.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public List<VeiculoModel> findAll() {
        return veiculoRepository.findAll();
    }

    @Override
    public VeiculoModel findById(String id) {
        return veiculoRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Veículo não existe"));
    }

    @Override
    public VeiculoModel create(VeiculoModel veiculoModel) {
        veiculoModel.setCreated(LocalDateTime.now());
        return veiculoRepository.save(veiculoModel);
    }

    @Override
    public boolean delete(String id) {

        VeiculoModel veiculo = veiculoRepository.findById(id).get();
        veiculoRepository.delete(veiculo);

        return true;
    }

    @Override
    public VeiculoModel update(String id, VeiculoModel veiculoModel) {

        VeiculoModel updatedVeiculo = veiculoRepository.findById(id).get();

        updatedVeiculo.setVeiculo(veiculoModel.getVeiculo());
        updatedVeiculo.setMarca(veiculoModel.getMarca());
        updatedVeiculo.setAno(veiculoModel.getAno());
        updatedVeiculo.setDescricao(veiculoModel.getDescricao());
        updatedVeiculo.setUpdated(LocalDateTime.now());

        veiculoRepository.save(updatedVeiculo);

        return updatedVeiculo;

    }


}
