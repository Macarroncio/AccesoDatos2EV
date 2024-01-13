package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ModeloDTO;
import com.example.demo.model.Marcas;
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

	@Override
	 public List<ModeloDTO> obtenerModelosPorIdMarca(Long idMarca) throws NotFoundException {
        Optional<Marcas> marca = marcasRepository.findById(idMarca);

        if (marca.isPresent()) {
            // Fetch models by the brand entity
            List<Modelos> modelosByMarca = modelosRepository.findByMarcasId(idMarca);
            
            // Convert the list of Modelos to a list of ModeloDTO
            List<ModeloDTO> modeloDTOs = modelosByMarca.stream()
                    .map(modelo -> new ModeloDTO(modelo.getId(), modelo.getNombre())) // Assuming you have a constructor in ModeloDTO
                    .collect(Collectors.toList());

            return modeloDTOs;
        } else {
            // Handle the case where the brand is not found
            throw new NotFoundException();
        }
    }
}