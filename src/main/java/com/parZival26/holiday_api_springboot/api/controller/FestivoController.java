package com.parZival26.holiday_api_springboot.api.controller;

import com.parZival26.holiday_api_springboot.application.dto.FestivoFechaDTO;
import com.parZival26.holiday_api_springboot.application.usecase.ListarFestivosUseCase;
import com.parZival26.holiday_api_springboot.application.usecase.VerificarFestivoUseCase;
import com.parZival26.holiday_api_springboot.domain.service.FestivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    private final VerificarFestivoUseCase verificarFestivoUseCase;
    private final ListarFestivosUseCase listarFestivosUseCase;

    public FestivoController(VerificarFestivoUseCase verificarFestivoUseCase, ListarFestivosUseCase listarFestivosUseCase) {
        this.verificarFestivoUseCase = verificarFestivoUseCase;
        this.listarFestivosUseCase = listarFestivosUseCase;
    }

    @GetMapping("/{pais}/{anio}")
    public ResponseEntity<List<FestivoFechaDTO>> listaFestivcs(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio
    ) {
        List<FestivoFechaDTO> lista = listarFestivosUseCase.ejecutar(anio, idPais);
        return ResponseEntity.ok(lista);
    }


    @GetMapping("/{pais}/{anio}/{mes}/{dia}")
    public ResponseEntity<String> validarFestivo(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {

        // Validación de fecha básica
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return ResponseEntity.badRequest().body("Fecha No Válida");
        }

        return  verificarFestivoUseCase.ejecutar(anio, mes, dia, idPais)
                ? ResponseEntity.ok("Es festivo")
                : ResponseEntity.ok("No es festivo");
    }
}
