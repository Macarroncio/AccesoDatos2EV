package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Modelos;
import com.example.demo.service.ModelosServiceImpl;

//Estas anotaciones se utilizan para indicar a java que se trata de componentes de una app Springboot
@Controller
@RequestMapping("/modelos")
public class ModelosController {
	
	//Aqui explicar que instanciamos el serviceimpl para poder acceder a los metodos creados en el mismo
	//el autowired le indica a spring la ruta a seguir a la hora de compilar
	@Autowired
	public ModelosServiceImpl modServ;
	
	
	@GetMapping("/listar")
	public String listarModelos(Model model) throws NotFoundException {
		List<Modelos> listaModelos = modServ.obtenerTodosModelos();
		model.addAttribute("listaModelos", listaModelos);
		return "modelos/listado";
	}
	
	/*Muy importante a la hora de diseñar la app de forma segura: todo lo que sean cosas tontas como listados
	*publicos y demás va con GET, todo lo que sea info privada usada en actualizaciones e inserciones va en POST
	*/
	@PostMapping("/actualizar/")
	public String actualizarModelos(Modelos modeloActualizado) throws NotFoundException {
		try {
			modServ.actualizarModelos(modeloActualizado);
		}catch (NotFoundException e){
			
			//TODO aqui hay que hacer algo para que devuelva un mensaje de que algo ha ido mal y el motivo
			e.printStackTrace();
			return "redirect:/modelos/formulario";
		}
		return "modelos/listar";
	}
	
	@GetMapping("/eliminar")
	public String eliminarModelos(Long id) throws NotFoundException {
		
		modServ.eliminarModelos(id);
		return "/modelos/listar";
	}
	
	@PostMapping("/anadir")
	public String anadirModelo(Modelos modelos) {
		modServ.anadirModelos(modelos);
		return "/modelos/listar";
	}
}
