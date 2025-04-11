package com.domain.repository;

import com.domain.model.Festivo;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository {


    List<Festivo> findByPais(Long idPais);
}
