package com.application.usecase;

import com.application.dto.PaisDTO;
import com.application.mapper.PaisMapper;
import com.application.service.PaisServiceImpl;
import com.domain.model.Pais;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListarPaisesuseCase {
    private final PaisServiceImpl paisService;
    private  final PaisMapper mapper;

    public ListarPaisesuseCase(PaisServiceImpl paisService, PaisMapper mapper) {
        this.paisService = paisService;
        this.mapper = mapper;
    }

    public List<PaisDTO> ejecutar() {
        List<Pais> paises = paisService.findAll();
        return paises.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


}
