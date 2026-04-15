package com.tujuego.loteria.controller;

import com.tujuego.loteria.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public List<Usuario> listar() {
        return List.of(
                new Usuario(1L, "Felipe", 1000.0),
                new Usuario(2L, "Juan", 500.0)
        );
    }
}