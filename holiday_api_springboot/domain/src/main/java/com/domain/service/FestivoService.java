package com.domain.service;

import com.domain.model.Festivo;
import com.domain.model.FestivoFecha;

import java.util.List;
import java.util.Optional;

public interface FestivoService {


    Optional<Festivo> esFestivo(int anio, int mes, int dia, Long idPais);

    List<FestivoFecha> listarFestivosPorPaisYAño(int anio, Long idPais);

    Optional<Festivo> findById(Long id);

    List<Festivo> findAll();

    Festivo save(Festivo festivo);

    void deleteById(Long id);

}
