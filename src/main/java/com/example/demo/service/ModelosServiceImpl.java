package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ModeloDTO;
import com.example.demo.model.Modelos;
import com.example.demo.repository.MarcasRepository;
import com.example.demo.repository.ModelosRepository;

@Service
public class ModelosServiceImpl implements ModelosService {
	//TODO tengo que revisar como hacer para relacionar con marcas
	
	
	@Autowired
	public ModelosRepository modelosRepository;
	@Autowired
	public MarcasRepository marcasRepository;

	@Override
	public List<Modelos> obtenerTodosModelos() throws NotFoundException {
		List<Modelos> listaModelos = modelosRepository.findAll();
		return listaModelos;
	}

	@Override
	public Optional<Modelos> obtenerModelosPorId(Long id) {
		Optional<Modelos> modelo = modelosRepository.findById(id);
		return modelo;
	}

	@Override
	public Modelos actualizarModelos(Modelos modeloActualizado) throws NotFoundException {
		Long id = modeloActualizado.getId();
		Optional<Modelos> modeloExistente = obtenerModelosPorId(id);
		
		if(modeloExistente.isPresent()) {
			modelosRepository.save(modeloActualizado);
		} else {
			throw new NotFoundException();
		}
		return null;
	}

	@Override
	public void anadirModelos(Modelos modelos) {
		modelosRepository.save(modelos);
		
	}

	@Override
	public void eliminarModelos(Long id) throws NotFoundException {
		Optional<Modelos> modelos = obtenerModelosPorId(id);
		if(modelos.isPresent()) {
			modelosRepository.delete(modelos.orElse(null));
		} else {
			throw new NotFoundException();
		}
		
		
	}
	// aqui basicamente lo que pasa es que se crea una copia de los modelos en un Data File Object (DTO) 
	// este objeto se utiliza para transferir datos .
	@Override
	public List<ModeloDTO> obtenerModelos() throws NotFoundException {
	    List<Modelos> modelos = modelosRepository.findAll();
	    return convertToDTOs(modelos);
	}
	//este es un metodo privado para el metodo "obtenerModelos()" que se encarga de copiar los modelos
	// y convertirlos en DTOs para que luego los envie de vuelta al metodo que lo llamo.
	private List<ModeloDTO> convertToDTOs(List<Modelos> modelos) {
	    return modelos.stream()
	    		.map(modelo -> new ModeloDTO(modelo.getId(), modelo.getMarca(),modelo.getNombre()))
	    		.collect(Collectors.toList());
	}
}