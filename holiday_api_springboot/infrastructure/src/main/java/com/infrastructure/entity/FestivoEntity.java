package com.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "festivo")
public class FestivoEntity {

    // Getters y setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Byte dia;
    private Byte mes;
    private Short diasPascua;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private PaisEntity pais;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoEntity tipo;

    public Long getIdTipo() {
        return tipo != null ? tipo.getId() : null;
    }

    public Long getIdPais() {
        return pais != null ? pais.getId() : null;
    }
}
