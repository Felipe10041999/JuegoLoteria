package com.tujuego.loteria.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

import com.tujuego.loteria.model.Participacion;
import com.tujuego.loteria.model.Usuario;
import com.tujuego.loteria.repository.ParticipacionRepository;
import com.tujuego.loteria.repository.UsuarioRepository;

@RestController
@RequestMapping("/juego")
@CrossOrigin
public class JuegoController {

    private final ParticipacionRepository participacionRepository;
    private final UsuarioRepository usuarioRepository;

    public JuegoController(ParticipacionRepository participacionRepository,
                           UsuarioRepository usuarioRepository) {
        this.participacionRepository = participacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/ganador")
    public String obtenerGanador() {

        List<Participacion> participaciones = participacionRepository.findAll();

        // validar que haya participantes
        if (participaciones.isEmpty()) {
            return "No hay participantes";
        }

        // número aleatorio (1–5)
        int numeroGanador = new Random().nextInt(5) + 1;

        Participacion ganador = null;

        // buscar ganador
        for (Participacion p : participaciones) {
            if (p.getNumeroElegido() == numeroGanador) {
                ganador = p;
                break;
            }
        }

        // calcular premio
        double apuesta = 100;
        double total = participaciones.size() * apuesta;

        if (ganador != null) {
            Usuario usuarioGanador = ganador.getUsuario();

            // sumar saldo
            usuarioGanador.setSaldo(usuarioGanador.getSaldo() + total);

            // guardar en BD
            usuarioRepository.save(usuarioGanador);

            return "Ganador: " + usuarioGanador.getNombre() +
                    " ganó " + total +
                    " con número " + numeroGanador;
        }

        return "Nadie eligió el número " + numeroGanador;
    }
    @DeleteMapping("/reset")
    public String resetearJuego() {

        participacionRepository.deleteAll();

        return "Juego reiniciado, participaciones eliminadas";
    }
}