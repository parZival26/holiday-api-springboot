package com.infrastructure.persistence.jpa;

import com.infrastructure.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPaisRepository extends JpaRepository<PaisEntity, Long> {

    @Modifying
    @Query("DELETE FROM PaisEntity p WHERE p.id = :id")
    void deleteById(@Param("id") Long id);

}
