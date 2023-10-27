package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.VentaAccesorio;
import com.Gamer.Joks.repository.VentaAccesorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/venta-accesorios")
public class VentaAccesorioController {

    @Autowired
    private VentaAccesorioRepository ventaAccesorioRepository;

    @GetMapping("/")
    public String vistaVentaAccesorios(Model model) {
        List<VentaAccesorio> ventaAccesorios = ventaAccesorioRepository.findAll();
        model.addAttribute("ventaAccesoriosList", ventaAccesorios); // Cambiamos el nombre del atributo para coincidir con la vista
        return "ventaAccesorio"; // Asegúrate de tener una plantilla llamada "ventaAccesorio.html" para mostrar la lista de venta de accesorios.
    }
}
