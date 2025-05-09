package com.application.mapper;

import com.application.dto.CreateTipoDTO;
import com.application.dto.UpdateTipoDTO;
import com.domain.model.Tipo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoMapper {
    Tipo toModel(CreateTipoDTO createTipoDTO);
    Tipo toModel(UpdateTipoDTO updateTipoDTO);
}
