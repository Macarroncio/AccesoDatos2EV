/**
 * Pre:---
 * Post: Controlador para manejar las solicitudes relacionadas con las operaciones CRUD de la entidad "Marcas".
 */
package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Marcas;
import com.example.demo.service.MarcasServiceImpl;

@Controller
@RequestMapping("/marcas")
public class MarcasController {

    // Servicio para realizar operaciones relacionadas con la entidad "Marcas".
    @Autowired
    public MarcasServiceImpl marServ;

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/marcas/listar" y muestra un listado de todas las marcas.
     */
    @GetMapping("/listar")
    public String listarMarcas(Model model) throws NotFoundException {
        List<Marcas> listaMarcas = marServ.obtenerTodasMarcas();
        model.addAttribute("listaMarcas", listaMarcas);

        String mensajeExito = "Operación realizada con éxito";
        model.addAttribute("mensajeExito", mensajeExito);

        return "listadoMarcas";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/marcas/actualizar/{id}" y actualiza la marca con el ID proporcionado.
     */
    @GetMapping("/actualizar/{id}")
    public String actualizarMarcas(@PathVariable Long id) throws NotFoundException {
        try {
            Optional<Marcas> optMarca = marServ.obtenerMarcasPorId(id);
            Marcas marcaActualizada = optMarca.orElse(null);
            marServ.actualizarMarca(marcaActualizada);
        } catch (NotFoundException e) {
            // Manejar la excepción y devolver un mensaje de error.
            e.printStackTrace();
            return "marcas/listar"; // Considerar cambiar a un nombre lógico de vista de error.
        }
        return "formularioMarca";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/marcas/eliminar/{id}" y elimina la marca con el ID proporcionado.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarMarcas(@PathVariable Long id) throws NotFoundException {
        marServ.eliminarMarcas(id);
        return "redirect:/marcas/listar";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/marcas/formulario" y muestra el formulario para agregar una nueva marca.
     */
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("marcas", new Marcas());
        return "formularioMarca";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes POST a "/marcas/anadir" y añade una nueva marca.
     */
    @PostMapping("/anadir")
    public String anadirModelo(Marcas marcas) {
        marServ.anadirMarcas(marcas);
        return "redirect:/marcas/listar";
    }
}
