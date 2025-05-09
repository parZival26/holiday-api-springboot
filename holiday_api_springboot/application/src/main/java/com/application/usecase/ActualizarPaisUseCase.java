package com.application.usecase;

import com.application.dto.PaisDTO;
import com.application.dto.UpdatePaisDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.PaisMapper;
import com.application.service.PaisServiceImpl;
import com.domain.model.Pais;
import org.springframework.stereotype.Component;

@Component
public class ActualizarPaisUseCase {
    private final PaisServiceImpl paisService;
    private final PaisMapper mapper;

    public ActualizarPaisUseCase(PaisServiceImpl paisService, PaisMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public PaisDTO ejecutar(UpdatePaisDTO updatePaisDTO) {
        Pais pais = paisService.findById(updatePaisDTO.getId())
                .orElseThrow(() -> new NotFoundException("No se encontró el país con id: " + updatePaisDTO.getId()));

        pais.setNombre(updatePaisDTO.getNombre());
        return mapper.toDto(paisService.save(pais));
    }
}
