package com.application.usecase;

import com.application.dto.CreateTipoDTO;
import com.application.mapper.TipoMapper;
import com.domain.model.Tipo;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class CreateTipoUseCase {
    private final TipoService tipoService;
    private final TipoMapper tipoMapper;

    public CreateTipoUseCase(TipoService tipoService, TipoMapper tipoMapper) {
        this.tipoService = tipoService;
        this.tipoMapper = tipoMapper;
    }

    public Tipo ejecutar(CreateTipoDTO tipoDTO) {
        Tipo tipo = tipoMapper.toModel(tipoDTO);
        return tipoService.save(tipo);
    }
}
