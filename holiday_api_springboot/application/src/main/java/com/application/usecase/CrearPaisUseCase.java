package com.application.usecase;

import com.application.dto.CreatePaisDTO;
import com.application.mapper.PaisMapper;
import com.domain.model.Pais;
import com.domain.service.PaisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CrearPaisUseCase {
    private static final Logger logger = LoggerFactory.getLogger(CrearPaisUseCase.class); // Add logger
    private final PaisService paisService;
    private final PaisMapper mapper;

    public CrearPaisUseCase(PaisService paisService, PaisMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public Pais ejecutar(CreatePaisDTO createPaisDTO) {
        logger.info("CreatePaisDTO received with nombre: {}", createPaisDTO.getNombre());
        Pais pais = mapper.toEntity(createPaisDTO);
        // Assuming Pais has getNombre() and getId()
        logger.info("Pais object after mapping from DTO: id={}, nombre={}", pais.getId(), pais.getNombre());
        Pais savedPais = paisService.save(pais);
        logger.info("Pais object after save service call: id={}, nombre={}", savedPais.getId(), savedPais.getNombre());
        return savedPais;
    }

}
