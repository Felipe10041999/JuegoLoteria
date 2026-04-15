package com.tujuego.loteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tujuego.loteria.model.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
}