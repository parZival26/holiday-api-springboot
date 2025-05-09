package com.domain.service;

import com.domain.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisService {

    Optional<Pais> findById(Long id);

    List<Pais> findAll();

    Pais save(Pais pais);

    void deleteById(Long id);
}
