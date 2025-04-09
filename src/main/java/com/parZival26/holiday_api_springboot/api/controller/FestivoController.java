package com.parZival26.holiday_api_springboot.api.controller;

import com.parZival26.holiday_api_springboot.domain.service.FestivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {

    private final FestivoService festivoService;

    public FestivoController(FestivoService festivoService) {
        this.festivoService = festivoService;
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

        return festivoService.esFestivo(anio, mes, dia, idPais)
                .map(f -> ResponseEntity.ok("Es Festivo"))
                .orElse(ResponseEntity.ok("No es Festivo"));
    }
}
