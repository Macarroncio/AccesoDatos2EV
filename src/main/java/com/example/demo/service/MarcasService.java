package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.Marcas;

public interface MarcasService {
	public List<Marcas> obtenerTodasMarcas() throws NotFoundException;

    public Optional<Marcas> obtenerMarcasPorId(Long id);

    public Marcas actualizarMarca(Marcas marcaActualizada) throws NotFoundException;
    
    public void anadirMarcas (Marcas marcas);

	public void eliminarMarcas(Long id)throws NotFoundException;
}
