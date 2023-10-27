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

@Controller
@RequestMapping("/ventas")
public class VentaFormController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/formulario")
    public String formularioVenta(Model model) {
        Venta nuevaVenta = new Venta();
        model.addAttribute("venta", nuevaVenta);
        return "ventaForm"; // Asegúrate de tener una plantilla llamada "ventaForm.html" para el formulario de venta.
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("venta") Venta venta, Model model) {
        try {
            ventaRepository.save(venta);
            return "redirect:/vista/";
        } catch (Exception e) {
            // Manejo de errores, por ejemplo, agregar un mensaje de error al modelo
            model.addAttribute("error", "Error al guardar la venta: " + e.getMessage());
            return "vista";
        }
    }
}
