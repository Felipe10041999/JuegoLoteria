package com.tujuego.loteria.model;

public class Usuario {

    private Long id;
    private String nombre;
    private Double saldo;

    // Constructor vacío
    public Usuario() {}

    // Constructor con datos
    public Usuario(Long id, String nombre, Double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
}