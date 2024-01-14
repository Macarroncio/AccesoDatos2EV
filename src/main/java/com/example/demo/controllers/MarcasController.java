package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Marcas;
import com.example.demo.service.MarcasServiceImpl;


@Controller
@RequestMapping("/marcas")
public class MarcasController {
	
	

	//TODO añadir todos los comentarios pertinentes para cada funcion
	@Autowired
	public MarcasServiceImpl marServ;

	@GetMapping("/listar")
	public String listarMarcas(Model model) throws NotFoundException {
		List<Marcas> listaMarcas = marServ.obtenerTodasMarcas();
		model.addAttribute("listaMarcas", listaMarcas);
		
		String mensajeExito = "Operación realizada con éxito";
        model.addAttribute("mensajeExito", mensajeExito);
		
        return "listadoMarcas";
	}

<<<<<<< HEAD
    /**
     * Pre:---
     * Post: Maneja las solicitudes GET a "/marcas/actualizar/{id}" y actualiza la marca con el ID proporcionado.
     */
    @GetMapping("/actualizar/{id}")
    public String actualizarMarcas(@PathVariable Long id, Model model) throws NotFoundException {
        try {
            Optional<Marcas> optMarca = marServ.obtenerMarcasPorId(id);
            Marcas marcaActualizada = optMarca.orElse(null);
            if(optMarca.isPresent()) {
            	model.addAttribute("marca",marcaActualizada);
            	marServ.actualizarMarca(marcaActualizada);
            	return "formularioMarca";
            }else return "redirect:/marcas/listar";
        } catch (NotFoundException e) {
            // Manejar la excepción y devolver un mensaje de error.
            e.printStackTrace();
            return "marcas/listar"; // Considerar cambiar a un nombre lógico de vista de error.
        }
    }
=======
	@GetMapping("/actualizar/{id}")
	public String actualizarMarcas(@PathVariable Long id) throws NotFoundException {
		try {
			Optional<Marcas> optMarca = marServ.obtenerMarcasPorId(id);
			Marcas marcaActualizada = optMarca.orElse(null);
			marServ.actualizarMarca(marcaActualizada);
		}catch (NotFoundException e){
>>>>>>> parent of d94bf38 (Merge branch 'main' of https://github.com/Macarroncio/AccesoDatos2EV)

			//TODO aqui hay que hacer algo para que devuelva un mensaje de que algo ha ido mal y el motivo
			//TODO hay que modificar el service para que acepte un id 
			e.printStackTrace();
			return "marcas/listar";
		}
		return "formularioMarca";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMarcas(@PathVariable Long id) throws NotFoundException {

		marServ.eliminarMarcas(id);
		return "redirect:/marcas/listar";
	}
	
	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("marcas", new Marcas());
		return "formularioMarca";
	}
	

	@PostMapping("/anadir")
	public String anadirModelo(Marcas marcas) {
		marServ.anadirMarcas(marcas);
		return "redirect:/marcas/listar";
	}
}
