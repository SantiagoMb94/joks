package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.Venta;
import com.Gamer.Joks.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/vista")
    public String vistaVentas(Model model) {
        List<Venta> ventas = ventaRepository.findAll();
        model.addAttribute("ventasList", ventas); // Cambiamos el nombre del atributo para coincidir con la vista
        return "venta"; // Asegúrate de tener una plantilla llamada "venta.html" para mostrar la lista de ventas.
    }
}