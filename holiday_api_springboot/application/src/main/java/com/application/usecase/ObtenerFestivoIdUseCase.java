package com.application.usecase;

import com.domain.model.Festivo;
import com.domain.service.FestivoService;
import org.springframework.stereotype.Component;

@Component
public class ObtenerFestivoIdUseCase {
    private final FestivoService festivoService;

    public ObtenerFestivoIdUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    public Festivo ejecutar(Long id) {
        return festivoService.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el festivo con id: " + id));
    }
}
