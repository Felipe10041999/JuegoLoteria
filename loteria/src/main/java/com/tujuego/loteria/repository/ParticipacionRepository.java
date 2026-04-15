package com.tujuego.loteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tujuego.loteria.model.Participacion;

public interface ParticipacionRepository extends JpaRepository<Participacion, Long> {
}