package com.parZival26.holiday_api_springboot.application.service;

import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import com.parZival26.holiday_api_springboot.domain.service.FestivoService;

import java.util.List;
import java.util.Optional;

public class FestivoServiceImpl implements FestivoService {

    @Override
    public Optional<Festivo> esFestivo(int anio, int mes, int dia, Long idPais) {
        return Optional.empty();
    }

    @Override
    public List<Festivo> listarFestivosPorPaisYAño(int anio, Long idPais) {
        return List.of();
    }
}
