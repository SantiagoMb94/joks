package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.Juego;
import com.Gamer.Joks.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/juegos")
public class GameController {

    @Autowired
    private GameRepository juegoRepository;

    @GetMapping("/")
    public String vistaJuegos(Model model) {
        List<Juego> juegos = juegoRepository.findAll();
        model.addAttribute("juegosList", juegos); // Cambiamos el nombre del atributo para coincidir con la vista
        return "juego"; // Asegúrate de tener una plantilla llamada "juego.html" para mostrar la lista de juegos.
    }
}
