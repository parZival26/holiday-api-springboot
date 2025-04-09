package com.parZival26.holiday_api_springboot.infrastructure.mapper;
import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import com.parZival26.holiday_api_springboot.infrastructure.entity.FestivoEntity;
import com.parZival26.holiday_api_springboot.infrastructure.entity.PaisEntity;
import com.parZival26.holiday_api_springboot.infrastructure.entity.TipoEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FestivoEntityMapper {
    @Mapping(source = "pais.id", target = "idPais")
    @Mapping(source = "tipo.id", target = "idTipo")
    Festivo toModel(FestivoEntity entity);

    @Mapping(target = "pais", source = "idPais", qualifiedByName = "idToPaisEntity")
    @Mapping(target = "tipo", source = "idTipo", qualifiedByName = "idToTipoEntity")
    FestivoEntity toEntity(Festivo model);

    @Named("idToPaisEntity")
    default PaisEntity idToPaisEntity(Long id) {
        if (id == null) {
            return null;
        }
        PaisEntity entity = new PaisEntity();
        // Solo establecemos el ID, el resto lo maneja JPA
        entity.setId(id);
        return entity;
    }

    @Named("idToTipoEntity")
    default TipoEntity idToTipoEntity(Long id) {
        if (id == null) {
            return null;
        }
        TipoEntity entity = new TipoEntity();
        // Solo establecemos el ID, el resto lo maneja JPA
        entity.setId(id);
        return entity;
    }
}