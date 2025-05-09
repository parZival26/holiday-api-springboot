package com.application.usecase;

import com.domain.model.Tipo;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ObtenerTipoIdUseCase {
    private final TipoService tipoService;

    public ObtenerTipoIdUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    public Optional<Tipo> ejecutar(Long id) {
        return tipoService.findById(id);
    }
}
