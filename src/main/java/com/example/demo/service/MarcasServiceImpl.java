package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.model.Marcas;
import com.example.demo.repository.MarcasRepository;

//En esta clase implementamos las funciones creadas en los services de cada model
//Con esta anotación indicamos al programa que se trata de un componente
@Service
public class MarcasServiceImpl implements MarcasService {
	//Esta anotación indica al programa que tiene que usar este repository concreto 
	//para las operaciones CRUD que se van a desarrollar en este service
	@Autowired
	public MarcasRepository marcasRepository;

	/*Esta función no recibe parametros y al ser llamada hace una llamada al repository
	 * el cual extiende de Jpa y tiene implementadas funciones básicas como findAll(), 
	 * que devuelven una lista de los elementos dentro de una tabla de una BDD
	 * */ 
	@Override
	public List<Marcas> obtenerTodasMarcas() throws NotFoundException {
		List <Marcas> listadoMarcas = marcasRepository.findAll();
		if(listadoMarcas.isEmpty()) {
			throw new NotFoundException();
		} else {
			return listadoMarcas;
		}
	}
	
	/*
	 * Misma lógica, accede al repository para, a través de Jpa y pasando un Long "id", devuelve
	 * aquellos resultados de la BDD que coincidan con ese id
	 * */
	@Override
	public Optional<Marcas> obtenerMarcasPorId(Long id) {
		Optional<Marcas> marca = marcasRepository.findById(id);
		return marca;
	}

	/*
	 * 
	 * */
	@Override
	public Marcas actualizarMarca(Marcas marcaActualizada) throws NotFoundException {
		Long id = marcaActualizada.getId();
		Optional<Marcas> marcaExistente = obtenerMarcasPorId(id);
		
	    if (marcaExistente.isPresent()) {
	        return marcasRepository.save(marcaActualizada);
	    } else {
	        throw new NotFoundException();
	    }
	}

	@Override
	public void anadirMarcas(Marcas marcas) {
		marcasRepository.save(marcas);
		
	}

	@Override
	public void eliminarMarcas(Long id) throws NotFoundException {
		Optional<Marcas> optMarca = obtenerMarcasPorId(id);
		if(optMarca.isPresent()) {
			Marcas marca = optMarca.orElse(null);
			marcasRepository.delete(marca);
		} else {
			throw new NotFoundException();
		}		
	}
	
	
}
