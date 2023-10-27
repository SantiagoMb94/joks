package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.Accesorio;
import com.Gamer.Joks.repository.AccesorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/accesorios")
public class AccesorioController {

    @Autowired
    private AccesorioRepository accesorioRepository;

    @GetMapping("/")
    public String vistaAccesorios(Model model) {
        List<Accesorio> accesorios = accesorioRepository.findAll();
        model.addAttribute("accesoriosList", accesorios); // Cambiamos el nombre del atributo para coincidir con la vista
        return "accesorio"; // Asegúrate de tener una plantilla llamada "accesorio.html" para mostrar la lista de accesorios.
    }
}
