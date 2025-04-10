package com.parZival26.holiday_api_springboot.domain.service;

import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import com.parZival26.holiday_api_springboot.domain.model.FestivoFecha;

import java.util.List;
import java.util.Optional;

public interface FestivoService {


    Optional<Festivo> esFestivo(int anio, int mes, int dia, Long idPais);

    List<FestivoFecha> listarFestivosPorPaisYAño(int anio, Long idPais);
}
