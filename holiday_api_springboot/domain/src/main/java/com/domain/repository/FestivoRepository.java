package com.domain.repository;

import com.domain.model.Festivo;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository {


    List<Festivo> findByPais(Long idPais);

    Optional<Festivo> findById(Long id);

    List<Festivo> findAll();

    Festivo save(Festivo festivo);

    void deleteById(Long id);
}
