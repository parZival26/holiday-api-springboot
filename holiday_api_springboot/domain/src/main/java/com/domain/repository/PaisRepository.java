package com.domain.repository;

import com.domain.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisRepository {

    Optional<Pais> findById(Long id);

    List<Pais> findAll();
}
