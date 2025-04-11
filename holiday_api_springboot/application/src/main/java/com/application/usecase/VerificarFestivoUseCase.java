package com.application.usecase;

import com.domain.service.FestivoService;
import org.springframework.stereotype.Component;

@Component
public class VerificarFestivoUseCase {
    private final FestivoService festivoService;

    public VerificarFestivoUseCase(FestivoService festivoService) {
        this.festivoService = festivoService;
    }

    public boolean ejecutar(int anio, int mes, int dia, Long idPais) {
        return festivoService.esFestivo(anio, mes, dia, idPais).isPresent();
    }
}
