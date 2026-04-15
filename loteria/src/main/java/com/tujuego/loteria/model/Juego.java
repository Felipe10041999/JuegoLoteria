package com.tujuego.loteria.model;

import jakarta.persistence.*;

@Entity
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;

    private Integer numeroGanador;

    public Juego() {}

    public Juego(Double monto, Integer numeroGanador) {
        this.monto = monto;
        this.numeroGanador = numeroGanador;
    }

    public Long getId() { return id; }

    public Double getMonto() { return monto; }
    public void setMonto(Double monto) { this.monto = monto; }

    public Integer getNumeroGanador() { return numeroGanador; }
    public void setNumeroGanador(Integer numeroGanador) { this.numeroGanador = numeroGanador; }
}