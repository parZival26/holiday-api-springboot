package com.parZival26.holiday_api_springboot.application.usecase;

import com.parZival26.holiday_api_springboot.application.dto.FestivoFechaDTO;
import com.parZival26.holiday_api_springboot.application.mapper.FestivoFechaMapper;
import com.parZival26.holiday_api_springboot.domain.model.FestivoFecha;
import com.parZival26.holiday_api_springboot.domain.service.FestivoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarFestivosUseCase {
    private final FestivoService festivoService;
    private final FestivoFechaMapper mapper;

    public ListarFestivosUseCase(FestivoService festivoService, FestivoFechaMapper mapper) {
        this.festivoService = festivoService;
        this.mapper = mapper;
    }

    public List<FestivoFechaDTO> ejecutar(int anio, Long idPais) {
        List<FestivoFecha> festivosDelDominio = festivoService.listarFestivosPorPaisYAño(anio, idPais);
        return mapper.toDtoList(festivosDelDominio);
    }
}
