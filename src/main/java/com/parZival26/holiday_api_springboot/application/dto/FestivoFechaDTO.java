package com.parZival26.holiday_api_springboot.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class FestivoFechaDTO {
    @Getter @Setter
    private LocalDate fecha;

    @Getter
    @Setter
    private String nombre;

    public FestivoFechaDTO(LocalDate fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
