package com.parZival26.holiday_api_springboot.domain.repository;

import com.parZival26.holiday_api_springboot.domain.model.Festivo;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository {


    List<Festivo> findByPais(Long idPais);
}
