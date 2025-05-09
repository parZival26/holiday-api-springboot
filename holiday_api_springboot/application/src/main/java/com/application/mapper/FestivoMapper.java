package com.application.mapper;

import com.application.dto.CreateFestivoDTO;
import com.application.dto.UpdateFestivoDto;
import com.domain.model.Festivo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FestivoMapper {
    Festivo toModel(CreateFestivoDTO createFestivoDTO);
    Festivo toModel(UpdateFestivoDto updateFestivoDto);
}
