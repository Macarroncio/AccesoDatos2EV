package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.Vehiculos;

public interface VehiculosService {
	
	public List<Vehiculos> obtenerTodosVehiculos() throws NotFoundException;
	
	public Optional<Vehiculos> obtenerVehiculosPorId(Long id);
	
	public Vehiculos actualizarVehiculos(Vehiculos vehiculoActualizado) throws NotFoundException;
	
	public void anadirVehiculos (Vehiculos vehiculos);
	
	void eliminarVehiculos(Long id) throws NotFoundException;

}
