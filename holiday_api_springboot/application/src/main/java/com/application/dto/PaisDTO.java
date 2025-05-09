package com.application.dto;

import lombok.Getter;
import lombok.Setter;

public class PaisDTO {
    @Getter @Setter
    private  Long id;

    @Getter @Setter
    private  String nombre;

    public PaisDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
