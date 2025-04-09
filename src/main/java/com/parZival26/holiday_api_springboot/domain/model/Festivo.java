package com.parZival26.holiday_api_springboot.domain.model;

import lombok.Getter;
import lombok.Setter;

public class Festivo {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private Long idPais;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private Byte dia;
    @Getter @Setter
    private Byte mes;
    @Getter @Setter
    private Short diasPascua;
    @Getter @Setter
    private Long idTipo;
}
