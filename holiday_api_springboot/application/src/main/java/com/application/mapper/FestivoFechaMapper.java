package com.application.mapper;

import com.application.dto.FestivoFechaDTO;
import com.domain.model.FestivoFecha;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FestivoFechaMapper {
    FestivoFechaDTO toDto(FestivoFecha festivoConFecha);
    List<FestivoFechaDTO> toDtoList(List<FestivoFecha> festivosConFecha);
}
