package com.application.usecase;

import com.application.exception.NotFoundException;
import com.application.mapper.PaisMapper;
import com.application.service.PaisServiceImpl;
import com.domain.model.Pais;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EliminarPaisUseCase {
    private final PaisServiceImpl paisService;
    private final PaisMapper mapper;

    public EliminarPaisUseCase(PaisServiceImpl paisService, PaisMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public void ejecutar(Long id) {
        Pais pais = paisService.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el país con id: " + id));

        paisService.deleteById(id);

    }
}
