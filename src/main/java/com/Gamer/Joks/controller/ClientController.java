package com.Gamer.Joks.controller;

import com.Gamer.Joks.persistence.entity.*;
import com.Gamer.Joks.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/vista")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private AccesorioRepository accesorioRepository;
    @Autowired
    private VentaAccesorioRepository ventaAccesorioRepository;
    @Autowired
    private VentaJuegoRepository ventaJuegoRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/")
    public String vistaCliente(Model model) {
        List<Juego> juegosList = gameRepository.findAll();
        List<Accesorio> accesoriosList = accesorioRepository.findAll();
        model.addAttribute("juegosList", juegosList);
        model.addAttribute("accesoriosList", accesoriosList);
        model.addAttribute("cliente", new Client()); // Agregamos un cliente vacío
        model.addAttribute("venta", new Venta()); // Agregamos una venta vacía
        return "vista"; // El nombre de la vista sin la extensión
    }
/*    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Client cliente, @ModelAttribute("venta") Venta venta, Model model) {
        try {
            clientRepository.save(cliente);
            ventaAccesorioRepository.save(new VentaAccesorio());
            ventaJuegoRepository.save(new VentaJuego());
            ventaRepository.save(venta);
            return "redirect:/vista";
        } catch (Exception e) {
            // Manejo de errores, por ejemplo, agregar un mensaje de error al modelo
            model.addAttribute("error", "Error al guardar el cliente: " + e.getMessage());
            return "vista";
        }
    }*/
@PostMapping("/guardarCliente")
public String guardarCliente(@ModelAttribute("cliente") Client cliente, @ModelAttribute("venta") Venta venta,
                             @RequestParam(value = "accesoriosSeleccionados", required = false) List<Long> accesoriosSeleccionados,
                             @RequestParam(value = "juegosSeleccionados", required = false) List<Long> juegosSeleccionados,
                             Model model) {
    try {
        // Guarda primero al cliente
        clientRepository.save(cliente);

        // Crea una nueva venta
        Venta nuevaVenta = new Venta();
        nuevaVenta.setCliente(cliente);

        // Asocia los accesorios seleccionados con la venta
        if (accesoriosSeleccionados != null) {
            List<Accesorio> accesorios = accesorioRepository.findAllById(accesoriosSeleccionados);
            nuevaVenta.setAccesorios(accesorios);
        }

        // Asocia los juegos seleccionados con la venta
        if (juegosSeleccionados != null) {
            List<Juego> juegos = gameRepository.findAllById(juegosSeleccionados);
            nuevaVenta.setJuegos(juegos);
        }

        // Calcula el precio, descuento y total de la venta aquí (debes implementar esta lógica)
        Double precioCalculado = calcularPrecio(nuevaVenta); // Reemplaza calcularPrecio con tu lógica real
        Double descuentoCalculado = calcularDescuento(nuevaVenta); // Reemplaza calcularDescuento con tu lógica real
        Double totalCalculado = precioCalculado - descuentoCalculado;

        nuevaVenta.setPrecio(precioCalculado);
        nuevaVenta.setDescuento(descuentoCalculado);
        nuevaVenta.setTotal(totalCalculado);

        // Guarda la nueva venta en la base de datos
        ventaRepository.save(nuevaVenta);

        return "redirect:/vista/";
    } catch (Exception e) {
        // Manejo de errores, por ejemplo, agregar un mensaje de error al modelo
        model.addAttribute("error", "Error al guardar el cliente: " + e.getMessage());
        return "vista";
    }
}

    // Implementa tus métodos de cálculo de precio y descuento aquí
    private Double calcularPrecio(Venta venta) {
        // Implementa tu lógica de cálculo de precio aquí
        return 0.0; // Cambia esto con tu lógica real
    }

    private Double calcularDescuento(Venta venta) {
        // Implementa tu lógica de cálculo de descuento aquí
        return 0.0; // Cambia esto con tu lógica real
    }

    @GetMapping("/salir")
    public String salir() {
        return "redirect:/vista/";
    }
}
