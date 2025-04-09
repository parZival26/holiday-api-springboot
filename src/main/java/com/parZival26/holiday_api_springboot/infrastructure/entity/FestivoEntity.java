package com.parZival26.holiday_api_springboot.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "festivo")
public class FestivoEntity {

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

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        this.dia = dia;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        this.mes = mes;
    }

    public Short getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(Short diasPascua) {
        this.diasPascua = diasPascua;
    }

    public PaisEntity getPais() {
        return pais;
    }

    public void setPais(PaisEntity pais) {
        this.pais = pais;
    }

    public TipoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntity tipo) {
        this.tipo = tipo;
    }

    public Long getIdTipo() {
        return tipo != null ? tipo.getId() : null;
    }

    public Long getIdPais() {
        return pais != null ? pais.getId() : null;
    }
}
