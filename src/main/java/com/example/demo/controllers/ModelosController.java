package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Modelos;
import com.example.demo.dto.ModeloDTO;
import com.example.demo.model.Marcas;
import com.example.demo.service.MarcasServiceImpl;
import com.example.demo.service.ModelosServiceImpl;

//Estas anotaciones se utilizan para indicar a java que se trata de componentes de una app Springboot
@Controller
@RequestMapping("/modelos")
public class ModelosController {
	
	//Aqui explicar que instanciamos el serviceimpl para poder acceder a los metodos creados en el mismo
	//el autowired le indica a spring la ruta a seguir a la hora de compilar
	@Autowired
	public ModelosServiceImpl modServ;
	@Autowired
	public MarcasServiceImpl marServ;
	
	@GetMapping("/listar")
	public String listarModelos(Model model) throws NotFoundException {
		List<Modelos> listaModelos = modServ.obtenerTodosModelos();
		model.addAttribute("listaModelos", listaModelos);
		return "listadoModelos";
	}
	
	/*Muy importante a la hora de diseñar la app de forma segura: todo lo que sean cosas tontas como listados
	*publicos y demás va con GET, todo lo que sea info privada usada en actualizaciones e inserciones va en POST
	*/
	@GetMapping("/actualizar/{id}")
	public String actualizarModelos(@PathVariable Long id, Modelos modeloActualizado) throws NotFoundException {
		try {
			modServ.actualizarModelos(modeloActualizado);
		}catch (NotFoundException e){
			
			//TODO aqui hay que hacer algo para que devuelva un mensaje de que algo ha ido mal y el motivo
			e.printStackTrace();
			return "redirect:/modelos/formulario";
		}
		return "modelos/listar";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarModelos(@PathVariable Long id	) throws NotFoundException {
		
		modServ.eliminarModelos(id);
		return "redirect:/modelos/listar";
	}
	
	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) throws NotFoundException{
		List<Marcas> listaMarcas = marServ.obtenerTodasMarcas();
		model.addAttribute("listaMarcas",listaMarcas);
		model.addAttribute("modelos",new Modelos());
		return "formularioModelo";
	}
	 @GetMapping("/getModelosByBrand")
	    public ResponseEntity<List<ModeloDTO>> getModelosByBrand(@RequestParam("Marca") Long brandId) throws NotFoundException {
	        List<ModeloDTO> modelos = modServ.obtenerModelosPorIdMarca(brandId);
	        return ResponseEntity.ok(modelos);
	    }
	
	@PostMapping("/anadir")
	public String anadirModelo(Modelos modelos) {
		modServ.anadirModelos(modelos);
		return "redirect:/modelos/listar";
	}
}
