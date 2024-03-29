package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehiculos;
import com.example.demo.repository.VehiculosRepository;

@Service
public class VehiculosServiceImpl implements VehiculosService{
	
	@Autowired
	public VehiculosRepository vehiculosRepository;
	
	@Override
	public List<Vehiculos> obtenerTodosVehiculos() throws NotFoundException{
		List<Vehiculos> listaVehiculos = vehiculosRepository.findAll();
		return listaVehiculos;
	}

	@Override
	public Optional<Vehiculos> obtenerVehiculosPorId(Long id) {
		Optional<Vehiculos> vehiculo = vehiculosRepository.findById(id);
		return vehiculo;
	}

	@Override
	public Vehiculos actualizarVehiculos(Vehiculos vehiculoActualizado) throws NotFoundException {
		Long id= vehiculoActualizado.getId();
		Optional<Vehiculos> vehiculoExistente= obtenerVehiculosPorId(id);

		if(vehiculoExistente.isPresent()) {
			vehiculosRepository.save(vehiculoActualizado);
		}
		else {
			throw new NotFoundException();
		}
		return null;
	}

	@Override
	public void anadirVehiculos(Vehiculos vehiculos) {
		vehiculosRepository.save(vehiculos);
		
	}

	@Override
	public void eliminarVehiculos(Long id) throws NotFoundException {
		Optional<Vehiculos> vehiculos=obtenerVehiculosPorId(id);
		if(vehiculos.isPresent()){
			vehiculosRepository.delete(vehiculos.orElse(null));
		}else {
			throw new NotFoundException();
		}	
	}
}
