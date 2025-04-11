package com.domain.model;

import lombok.Getter;
import lombok.Setter;

public class Festivo {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Pais pais;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private Byte dia;
    @Getter
    @Setter
    private Byte mes;
    @Getter
    @Setter
    private Short diasPascua;
    @Getter
    @Setter
    private Tipo tipo;

    public Long getIdTipo() {
        return tipo.getId();
    }
}
