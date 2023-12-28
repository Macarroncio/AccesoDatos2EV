package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Modelos;
import com.example.demo.repository.ModelosRepository;

@Service
public class ModelosServiceImpl implements ModelosService {
	
	@Autowired
	public ModelosRepository modelosRepository;

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

}
