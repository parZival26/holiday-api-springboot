package com.parZival26.holiday_api_springboot.domain.repository;

import com.parZival26.holiday_api_springboot.domain.model.Pais;

import java.util.List;
import java.util.Optional;

public interface PaisRepository {

    Optional<Pais> findById(Long id);

    List<Pais> findAll();
}
