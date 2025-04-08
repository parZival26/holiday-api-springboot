package com.parZival26.holiday_api_springboot.application.mapper;
import com.parZival26.holiday_api_springboot.application.dto.FestivoDTO;
import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper
public interface FestivoMapper {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "tipo.tipo", target = "tipo")
    @Mapping(source = "dia", target = "dia")
    @Mapping(source = "mes", target = "mes")
    FestivoDTO toDTO(Festivo festivo);

    List<FestivoDTO> toDTOList(List<Festivo> festivos);
}
