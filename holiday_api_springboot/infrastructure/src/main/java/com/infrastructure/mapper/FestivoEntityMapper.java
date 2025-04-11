package com.infrastructure.mapper;
import com.domain.model.Festivo;
import com.infrastructure.entity.FestivoEntity;
import com.infrastructure.entity.PaisEntity;
import com.infrastructure.entity.TipoEntity;

import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface FestivoEntityMapper {


    Festivo toModel(FestivoEntity entity);

    FestivoEntity toEntity(Festivo model);

}
