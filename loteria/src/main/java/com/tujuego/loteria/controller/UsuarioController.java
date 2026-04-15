package com.tujuego.loteria.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.tujuego.loteria.model.Usuario;
import com.tujuego.loteria.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // 📌 LISTAR
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // 📌 CREAR
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 🔐 LOGIN
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario login) {

        return usuarioRepository.findAll()
                .stream()
                .filter(u ->
                        u.getNombre().equals(login.getNombre()) &&
                                u.getPassword().equals(login.getPassword())
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }
}