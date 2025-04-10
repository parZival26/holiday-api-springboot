package com.parZival26.holiday_api_springboot.application.mapper;

import com.parZival26.holiday_api_springboot.application.dto.FestivoFechaDTO;
import com.parZival26.holiday_api_springboot.domain.model.FestivoFecha;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FestivoFechaMapper {
    FestivoFechaDTO toDto(FestivoFecha festivoConFecha);
    List<FestivoFechaDTO> toDtoList(List<FestivoFecha> festivosConFecha);
}
