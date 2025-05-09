package com.domain.service;

import com.domain.model.Tipo;

import java.util.List;
import java.util.Optional;

public interface TipoService {
    Optional<Tipo> findById(Long id);

    List<Tipo> findAll();

    Tipo save(Tipo tipo);

    void deleteById(Long id);
}
