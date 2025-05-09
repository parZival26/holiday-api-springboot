package com.application.usecase;

import com.application.exception.NotFoundException;
import com.domain.model.Festivo;
import com.domain.model.Tipo;
import com.domain.service.FestivoService;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class EliminarFestivoUseCase {
    private final FestivoService festivoService;

    public EliminarFestivoUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;

    }

    public void ejecutar(Long id) {
        Festivo festivo = festivoService.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el festivo con id: " + id));
        festivoService.deleteById(id);

    }
}
