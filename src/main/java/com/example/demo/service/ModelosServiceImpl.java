/**
 * Pre:---
 * Post: Implementación de la interfaz ModelosService que define las operaciones CRUD para la entidad "Modelos".
 */
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

    @Autowired
    private ModelosRepository modelosRepository;
    
    @Autowired
    private MarcasRepository marcasRepository;

    @Override
    public List<Modelos> obtenerTodosModelos() throws NotFoundException {
        return modelosRepository.findAll();
    }

    @Override
    public Optional<Modelos> obtenerModelosPorId(Long id) {
        return modelosRepository.findById(id);
    }

    @Override
    public Modelos actualizarModelos(Modelos modeloActualizado) throws NotFoundException {
        Long id = modeloActualizado.getId();
        Optional<Modelos> modeloExistente = obtenerModelosPorId(id);

        if (modeloExistente.isPresent()) {
            return modelosRepository.save(modeloActualizado);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void anadirModelos(Modelos modelos) {
        modelosRepository.save(modelos);
    }

    @Override
    public void eliminarModelos(Long id) throws NotFoundException {
        Optional<Modelos> modelos = obtenerModelosPorId(id);
        if (modelos.isPresent()) {
            modelosRepository.delete(modelos.orElse(null));
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<ModeloDTO> obtenerModelos() throws NotFoundException {
        List<Modelos> modelos = modelosRepository.findAll();
        return convertToDTOs(modelos);
    }

    private List<ModeloDTO> convertToDTOs(List<Modelos> modelos) {
        return modelos.stream()
                .map(modelo -> new ModeloDTO(modelo.getId(), modelo.getMarca(), modelo.getNombre()))
                .collect(Collectors.toList());
    }
}
