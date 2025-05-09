package com.application.usecase;

import com.application.mapper.TipoMapper;
import com.domain.model.Tipo;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTiposUseCase {
    private final TipoService tipoService;

    public ListarTiposUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    public List<Tipo> ejecutar() {
        return tipoService.findAll();
    }
}
