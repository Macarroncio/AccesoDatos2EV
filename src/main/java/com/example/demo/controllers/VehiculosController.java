package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Marcas;
import com.example.demo.model.Modelos;
import com.example.demo.model.Vehiculos;
import com.example.demo.service.MarcasServiceImpl;
import com.example.demo.service.ModelosServiceImpl;
import com.example.demo.service.VehiculosServiceImpl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/vehiculos")
public class VehiculosController {
	@Autowired
	public ModelosServiceImpl modServ;
	@Autowired
	public MarcasServiceImpl marServ;
	@Autowired
	public VehiculosServiceImpl vehServ;
	
	@GetMapping("/listar")
	public String listarVehiculos(Model model) throws NotFoundException{
		List<Vehiculos> listaVehiculos=vehServ.obtenerTodosVehiculos();
		List<Modelos> listaModelos=modServ.obtenerTodosModelos();
		List<Marcas> listaMarcas=marServ.obtenerTodasMarcas();
		model.addAttribute("listaVehiculos",listaVehiculos);
		model.addAttribute("listaModelos",listaModelos);
		model.addAttribute("listaMarcas",listaMarcas);
		return "listadoVehiculos";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizarVehiculos(@PathVariable Long id,Vehiculos vehiculoActualizado) throws NotFoundException{
		try {
			vehServ.actualizarVehiculos(vehiculoActualizado);
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			return "index";
		}
		return "index";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarVehiculos(@RequestParam Long id) throws NotFoundException{
		vehServ.eliminarVehiculos(id);
		return "index";
	}
	
	@GetMapping("/formulario")
	public String mostrarFormulario(Model model) throws NotFoundException{
		List<Marcas> listadoMarcas=marServ.obtenerTodasMarcas();
		List<Modelos> listadoModelos=modServ.obtenerTodosModelos();
		List<Vehiculos> listadoVehiculos=vehServ.obtenerTodosVehiculos();
		model.addAttribute("listaMarcas", listadoMarcas);
		model.addAttribute("listaModelos", listadoModelos);
		model.addAttribute("listaVehiculos", listadoVehiculos);
		model.addAttribute("vehiculo", new Vehiculos());
		return "formularioVehiculo";
	}
	
	@PostMapping("/anadir")
	public String anadirVehiculo(Vehiculos vehiculos) {
		vehServ.anadirVehiculos(vehiculos);
		return "redirect:/vehiculos/listar";
	}
}
