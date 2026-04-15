package com.tujuego.loteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tujuego.loteria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}