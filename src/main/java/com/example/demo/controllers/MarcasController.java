package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "listadoMarcas";
	}

	@PostMapping("/actualizar/")
	public String actualizarMarcas(Marcas marcaActualizado) throws NotFoundException {
		try {
			marServ.actualizarMarca(marcaActualizado);
		}catch (NotFoundException e){

			//TODO aqui hay que hacer algo para que devuelva un mensaje de que algo ha ido mal y el motivo
			e.printStackTrace();
			return "redirect:/marcas/formulario";
		}
		return "marcas/listar";
	}

	@GetMapping("/eliminar")
	public String eliminarMarcas(Long id) throws NotFoundException {

		marServ.eliminarMarcas(id);
		return "/marcas/listar";
	}

	@PostMapping("/anadir")
	public String anadirModelo(Marcas marcas) {
		marServ.anadirMarcas(marcas);
		return "/marcas/listar";
	}
}
