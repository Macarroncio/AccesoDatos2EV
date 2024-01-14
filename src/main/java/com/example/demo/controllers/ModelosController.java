/**
 * Pre:---
 * Post: Controlador para manejar las solicitudes relacionadas con las operaciones CRUD de la entidad "Modelos".
 */
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Modelos;
import com.example.demo.model.Marcas;
import com.example.demo.service.MarcasServiceImpl;
import com.example.demo.service.ModelosServiceImpl;

@Controller
@RequestMapping("/modelos")
public class ModelosController {

    // Servicios necesarios para realizar operaciones relacionadas con las entidades "Modelos" y "Marcas".
    @Autowired
    public ModelosServiceImpl modServ;
    @Autowired
    public MarcasServiceImpl marServ;

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/modelos/listar" y muestra un listado de todos los modelos.
     */
    @GetMapping("/listar")
    public String listarModelos(Model model) throws NotFoundException {
        List<Modelos> listaModelos = modServ.obtenerTodosModelos();
        model.addAttribute("listaModelos", listaModelos);
        return "listadoModelos";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/modelos/actualizar/{id}" y actualiza el modelo con el ID proporcionado.
     */
    @GetMapping("/actualizar/{id}")
    public String actualizarModelos(@PathVariable Long id, Modelos modeloActualizado) throws NotFoundException {
        try {
            modServ.actualizarModelos(modeloActualizado);
        } catch (NotFoundException e) {
            // Manejar la excepción y redirigir a la URL de formulario con un mensaje de error.
            e.printStackTrace();
            return "redirect:/modelos/formulario";
        }
        return "redirect:/modelos/listar";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/modelos/eliminar/{id}" y elimina el modelo con el ID proporcionado.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarModelos(@PathVariable Long id) throws NotFoundException {
        modServ.eliminarModelos(id);
        return "redirect:/modelos/listar";
    }

    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/modelos/formulario" y muestra el formulario para agregar un nuevo modelo.
     */
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) throws NotFoundException {
        List<Marcas> listaMarcas = marServ.obtenerTodasMarcas();
        model.addAttribute("listaMarcas", listaMarcas);
        model.addAttribute("modelos", new Modelos());
        return "formularioModelo";
    }
    
    @GetMapping("/obtenerModelos")
    public ResponseEntity<List<Modelos>> obtenerModelos() throws NotFoundException {
        // Your logic to fetch models
        List<Modelos> modelos = modServ.obtenerTodosModelos();// fetch models from the database or elsewhere
        return ResponseEntity.ok(modelos);
    }
    
    /**
     * Pre:---
     * Post: Maneja las solicitudes POST a "/modelos/anadir" y añade un nuevo modelo.
     */
    @PostMapping("/anadir")
    public String anadirModelo(Modelos modelos) {
        modServ.anadirModelos(modelos);
        return "redirect:/modelos/listar";
    }
}
