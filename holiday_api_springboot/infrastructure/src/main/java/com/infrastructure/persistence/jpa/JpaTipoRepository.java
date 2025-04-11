package com.infrastructure.persistence.jpa;

import com.infrastructure.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTipoRepository extends JpaRepository<TipoEntity, Long> {
}