package com.parZival26.holiday_api_springboot.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class FestivoFecha {
    @Getter @Setter
    private LocalDate fecha;
    @Getter @Setter
    private String nombre;

    public FestivoFecha(LocalDate fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

}
