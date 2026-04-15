package com.tujuego.loteria.model;

import jakarta.persistence.*;

@Entity
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroElegido;

    @ManyToOne
    private Usuario usuario;

    public Participacion() {}

    public Participacion(Integer numeroElegido, Usuario usuario) {
        this.numeroElegido = numeroElegido;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public Integer getNumeroElegido() { return numeroElegido; }
    public void setNumeroElegido(Integer numeroElegido) { this.numeroElegido = numeroElegido; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}