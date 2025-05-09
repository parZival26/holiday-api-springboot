package com.infrastructure.persistence;

import com.domain.model.Tipo;
import com.domain.repository.TipoRepository;
import com.infrastructure.entity.TipoEntity;
import com.infrastructure.mapper.TipoEntityMapper;
import com.infrastructure.persistence.jpa.JpaTipoRepository;
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

    @Override
    public Tipo save(Tipo tipo) {
        TipoEntity entity = mapper.toEntity(tipo);
        TipoEntity savedEntity = jpaTipoRepository.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaTipoRepository.deleteById(id);
    }
}