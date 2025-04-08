package com.parZival26.holiday_api_springboot.domain.repository;

import com.parZival26.holiday_api_springboot.domain.model.Festivo;

import java.util.List;
import java.util.Optional;

public interface FestivoRepository {

    /**
     * Consulta si existe un festivo para la fecha y país dados.
     * Devuelve el festivo si existe, vacío si no.
     */
    Optional<Festivo> findByFechaAndPais(int anio, int mes, int dia, Long idPais);

    /**
     * Lista todos los festivos de un país para un año dado.
     */
    List<Festivo> findByPaisAndAnio(Long idPais, int anio);
}
