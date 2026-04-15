package com.tujuego.loteria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String home() {
        return "🎉 Spring Boot funcionando correctamente";
    }
}