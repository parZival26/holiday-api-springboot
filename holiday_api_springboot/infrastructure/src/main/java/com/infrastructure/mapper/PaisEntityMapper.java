package com.infrastructure.mapper;

import com.domain.model.Pais;
import com.infrastructure.entity.PaisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisEntityMapper {
    Pais toModel(com.infrastructure.entity.PaisEntity entity);
    PaisEntity toEntity(com.domain.model.Pais model);
}
