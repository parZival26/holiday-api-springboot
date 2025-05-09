package com.infrastructure.persistence;

import com.domain.model.Festivo;
import com.domain.repository.FestivoRepository;
import com.infrastructure.entity.FestivoEntity;
import com.infrastructure.mapper.FestivoEntityMapper;
import com.infrastructure.persistence.jpa.JpaFestivoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Festivo> findById(Long id) {
        Optional<FestivoEntity> entityOptional = jpaFestivoRepository.findById(id);
        return entityOptional.map(mapper::toModel);
    }

    @Override
    public List<Festivo> findAll() {
        List<FestivoEntity> entityList = jpaFestivoRepository.findAll();
        return entityList.stream()
                .map(mapper::toModel)
                .toList();
    }

    @Override
    public Festivo save(Festivo festivo) {
        FestivoEntity entity = mapper.toEntity(festivo);
        FestivoEntity savedEntity = jpaFestivoRepository.save(entity);
        return mapper.toModel(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaFestivoRepository.deleteById(id);
    }
}
