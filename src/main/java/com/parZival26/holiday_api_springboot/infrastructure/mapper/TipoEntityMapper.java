package com.parZival26.holiday_api_springboot.infrastructure.mapper;

import com.parZival26.holiday_api_springboot.domain.model.Tipo;
import com.parZival26.holiday_api_springboot.infrastructure.entity.TipoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoEntityMapper {
    @Mapping(source = "nombre", target = "tipo")
    Tipo toModel(TipoEntity entity);

    @Mapping(source = "tipo", target = "nombre")
    TipoEntity toEntity(Tipo model);
}