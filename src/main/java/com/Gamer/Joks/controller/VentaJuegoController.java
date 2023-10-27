package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.VentaJuego;
import com.Gamer.Joks.repository.VentaJuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/venta-juegos")
public class VentaJuegoController {

    @Autowired
    private VentaJuegoRepository ventaJuegoRepository;

    @GetMapping("/")
    public String vistaVentaJuegos(Model model) {
        List<VentaJuego> ventaJuegos = ventaJuegoRepository.findAll();
        model.addAttribute("ventaJuegosList", ventaJuegos); // Cambiamos el nombre del atributo para coincidir con la vista
        return "ventaJuego"; // Asegúrate de tener una plantilla llamada "ventaJuego.html" para mostrar la lista de venta de juegos.
    }
}
