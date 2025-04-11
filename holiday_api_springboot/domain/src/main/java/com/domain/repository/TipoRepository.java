package com.domain.repository;

import com.domain.model.Tipo;

import java.util.List;
import java.util.Optional;

public interface TipoRepository {

    Optional<Tipo> findById(Long id);

    List<Tipo> findAll();
}
