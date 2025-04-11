package com.application.usecase;

import com.application.dto.FestivoFechaDTO;
import com.application.mapper.FestivoFechaMapper;
import com.domain.model.FestivoFecha;
import com.domain.service.FestivoService;
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
