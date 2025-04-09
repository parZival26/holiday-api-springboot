package com.parZival26.holiday_api_springboot.application.dto;

import lombok.Getter;
import lombok.Setter;

public class FestivoDTO {
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String tipo;
    @Getter @Setter
    private Byte dia;
    @Getter @Setter
    private Byte mes;
}
