package com.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Festivo {
    private Long id;
    private Pais pais;
    private String nombre;
    private Byte dia;
    private Byte mes;
    private Short diasPascua;
    private Tipo tipo;

    public Long getIdTipo() {
        return tipo.getId();
    }
}
