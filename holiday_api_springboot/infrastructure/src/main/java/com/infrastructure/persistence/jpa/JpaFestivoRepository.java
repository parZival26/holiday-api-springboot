package com.infrastructure.persistence.jpa;

import com.domain.model.Festivo;
import com.infrastructure.entity.FestivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaFestivoRepository extends JpaRepository<FestivoEntity, Long> {

    @Query("SELECT f FROM FestivoEntity f WHERE f.pais.id = :paisId")
    List<FestivoEntity> findAllByPais(@Param("paisId") Long paisId);


    @Modifying
    @Query("DELETE FROM FestivoEntity f WHERE f.id = :id")
    void deleteById(@Param("id") Long id);
}
