package com.application.usecase;

import com.application.dto.UpdateTipoDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.TipoMapper;
import com.domain.model.Tipo;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class ActualizarTipoUseCase {
    private final TipoService tipoService;
    private final TipoMapper mapper;

    public ActualizarTipoUseCase(TipoService tipoService, TipoMapper mapper) {
        this.tipoService = tipoService;
        this.mapper = mapper;
    }

    public Tipo ejecutar(UpdateTipoDTO updateTipoDTO) {
        Tipo tipo = tipoService.findById(updateTipoDTO.getId())
                .orElseThrow(() -> new NotFoundException("No se encontró el tipo con id: " + updateTipoDTO.getId()));



        tipo.setTipo(updateTipoDTO.getTipo());
        return  tipoService.save(tipo);
    }
}
