package com.parZival26.holiday_api_springboot.infrastructure.persistence.jpa;

import com.parZival26.holiday_api_springboot.infrastructure.entity.FestivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaFestivoRepository extends JpaRepository<FestivoEntity, Long> {

    @Query("SELECT f FROM FestivoEntity f WHERE f.pais.id = :paisId")
    List<FestivoEntity> findAllByPais(@Param("paisId") Long paisId);
}
