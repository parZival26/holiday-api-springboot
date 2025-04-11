package com.infrastructure.mapper;

import com.domain.model.Tipo;
import com.infrastructure.entity.TipoEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TipoEntityMapper {
    Tipo toModel(TipoEntity entity);
    TipoEntity toEntity(Tipo model);
}
