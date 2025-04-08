package com.parZival26.holiday_api_springboot.domain.repository;

import com.parZival26.holiday_api_springboot.domain.model.Tipo;

import java.util.List;
import java.util.Optional;

public interface TipoRepository {

    Optional<Tipo> findById(Long id);

    List<Tipo> findAll();
}
