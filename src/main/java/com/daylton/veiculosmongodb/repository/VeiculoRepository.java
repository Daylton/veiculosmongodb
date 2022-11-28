package com.daylton.veiculosmongodb.repository;

import com.daylton.veiculosmongodb.model.VeiculoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeiculoRepository extends MongoRepository<VeiculoModel, String> {
}
