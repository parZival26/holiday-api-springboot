package com.parZival26.holiday_api_springboot.infrastructure.persistence;

import com.parZival26.holiday_api_springboot.domain.model.Tipo;
import com.parZival26.holiday_api_springboot.domain.repository.TipoRepository;
import com.parZival26.holiday_api_springboot.infrastructure.entity.TipoEntity;
import com.parZival26.holiday_api_springboot.infrastructure.mapper.TipoEntityMapper;
import com.parZival26.holiday_api_springboot.infrastructure.persistence.jpa.JpaTipoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoRepositoryImpl implements TipoRepository {

    private final JpaTipoRepository jpaTipoRepository;
    private final TipoEntityMapper mapper;

    public TipoRepositoryImpl(JpaTipoRepository jpaTipoRepository, TipoEntityMapper mapper) {
        this.jpaTipoRepository = jpaTipoRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Tipo> findById(Long id) {
        return jpaTipoRepository.findById(id)
                .map(mapper::toModel);
    }

    @Override
    public List<Tipo> findAll() {
        return jpaTipoRepository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }
}