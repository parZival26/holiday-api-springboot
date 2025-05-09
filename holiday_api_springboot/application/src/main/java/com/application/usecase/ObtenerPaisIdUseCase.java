package com.application.usecase;

import com.application.dto.PaisDTO;
import com.application.mapper.PaisMapper;
import com.application.service.PaisServiceImpl;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObtenerPaisIdUseCase {
    private final PaisServiceImpl paisService;
    private final PaisMapper mapper;

    public ObtenerPaisIdUseCase(PaisServiceImpl paisService, PaisMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public Optional<PaisDTO> ejecutar(Long id) {
        return paisService.findById(id)
                .map(pais -> {
                    PaisDTO paisDTO = mapper.toDto(pais);
                    return Optional.of(paisDTO);
                })
                .orElse(Optional.empty());
    }
}
