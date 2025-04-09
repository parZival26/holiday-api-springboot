package com.parZival26.holiday_api_springboot.application.mapper;
import com.parZival26.holiday_api_springboot.application.dto.FestivoDTO;
import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FestivoMapper {
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(target = "tipo", ignore = true) // Ignoramos el mapeo de tipo
    @Mapping(source = "dia", target = "dia")
    @Mapping(source = "mes", target = "mes")
    FestivoDTO toDTO(Festivo festivo);

    @AfterMapping
    default void setTipo(@MappingTarget FestivoDTO dto, Festivo festivo) {
        // Aquí implementarías la lógica para obtener el nombre del tipo
        // basado en el ID. Como solución temporal:
        dto.setTipo("Tipo " + festivo.getIdTipo());
    }

    List<FestivoDTO> toDTOList(List<Festivo> festivos);
}