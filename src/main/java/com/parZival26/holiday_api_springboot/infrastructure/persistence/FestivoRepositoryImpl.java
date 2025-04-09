package com.parZival26.holiday_api_springboot.infrastructure.persistence;

import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import com.parZival26.holiday_api_springboot.domain.repository.FestivoRepository;
import com.parZival26.holiday_api_springboot.infrastructure.entity.FestivoEntity;
import com.parZival26.holiday_api_springboot.infrastructure.mapper.FestivoEntityMapper;
import com.parZival26.holiday_api_springboot.infrastructure.persistence.jpa.JpaFestivoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FestivoRepositoryImpl implements FestivoRepository {

    private final JpaFestivoRepository jpaFestivoRepository;
    private final FestivoEntityMapper mapper;

    public FestivoRepositoryImpl(JpaFestivoRepository jpaFestivoRepository, FestivoEntityMapper mapper) {
        this.jpaFestivoRepository = jpaFestivoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Festivo> findByPais(Long idPais) {
        List<FestivoEntity> entityList = jpaFestivoRepository.findAllByPais(idPais);
        return entityList.stream()
                .map(mapper::toModel)
                .toList();
    }
}
