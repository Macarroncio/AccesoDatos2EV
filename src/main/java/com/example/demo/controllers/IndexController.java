/**
 * Pre:---
 * Post: Controlador para manejar las solicitudes relacionadas con la página de inicio.
 */
package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a la ruta raíz ("/") y devuelve la vista "index".
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }
}


