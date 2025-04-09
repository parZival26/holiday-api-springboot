package com.parZival26.holiday_api_springboot.infrastructure.persistence.jpa;

import com.parZival26.holiday_api_springboot.infrastructure.entity.TipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTipoRepository extends JpaRepository<TipoEntity, Long> {
}