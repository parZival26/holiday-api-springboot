package com.application.mapper;

import com.application.dto.CreatePaisDTO;
import com.application.dto.PaisDTO;
import com.application.dto.UpdatePaisDTO;
import com.domain.model.Pais;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    PaisDTO toDto(com.domain.model.Pais pais);
    CreatePaisDTO toCreateDto(com.domain.model.Pais pais);
    UpdatePaisDTO toUpdateDto(com.domain.model.Pais pais);
    Pais toEntity(com.application.dto.CreatePaisDTO createPaisDTO);
}
