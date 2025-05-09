package com.application.usecase;

import com.application.dto.CreateFestivoDTO;
import com.application.exception.NotFoundException;
import com.application.mapper.FestivoMapper;
import com.domain.model.Festivo;
import com.domain.model.Pais;
import com.domain.model.Tipo;
import com.domain.service.FestivoService;
import com.domain.service.PaisService;
import com.domain.service.TipoService;
import org.springframework.stereotype.Component;

@Component
public class CreateFestivoUseCase {
    private final FestivoService festivoService;
    private final TipoService tipoService;
    private final PaisService paisService;
    private final FestivoMapper festivoMapper;

    public CreateFestivoUseCase(FestivoService festivoService, TipoService tipoService, PaisService paisService,
            FestivoMapper festivoMapper) {
        this.festivoService = festivoService;
        this.tipoService = tipoService;
        this.paisService = paisService;
        this.festivoMapper = festivoMapper;
    }

    public Festivo ejecutar(CreateFestivoDTO createFestivoDTO) {
        // validate if tipo and pais exists
        Tipo tipo = tipoService.findById(createFestivoDTO.getTipoId())
                .orElseThrow(() -> new NotFoundException("Tipo not found with id: " + createFestivoDTO.getTipoId()));

        Pais pais = paisService.findById(createFestivoDTO.getPaisId())
                .orElseThrow(() -> new NotFoundException("Pais not found with id: " + createFestivoDTO.getPaisId()));

        Festivo festivo = festivoMapper.toModel(createFestivoDTO);
        // Asegúrate de que las entidades Pais y Tipo se asignan al modelo Festivo
        festivo.setPais(pais);
        festivo.setTipo(tipo);

        return festivoService.save(festivo);
    }
}
