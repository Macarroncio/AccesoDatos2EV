/**
 * Pre:---
 * Post: Implementación de la interfaz MarcasService que define las operaciones CRUD para la entidad "Marcas".
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Marcas;
import com.example.demo.repository.MarcasRepository;

@Service
public class MarcasServiceImpl implements MarcasService {

    @Autowired
    private MarcasRepository marcasRepository;

    @Override
    public List<Marcas> obtenerTodasMarcas() throws NotFoundException {
        List<Marcas> listadoMarcas = marcasRepository.findAll();
        if (listadoMarcas.isEmpty()) {
            throw new NotFoundException();
        } else {
            return listadoMarcas;
        }
    }

    @Override
    public Optional<Marcas> obtenerMarcasPorId(Long id) {
        return marcasRepository.findById(id);
    }

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
        if (optMarca.isPresent()) {
            Marcas marca = optMarca.orElse(null);
            marcasRepository.delete(marca);
        } else {
            throw new NotFoundException();
        }
    }
}
