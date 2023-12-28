package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.model.Modelos;



public interface ModelosService {
	//Esta es la interfaz en la que se declaran las consultas de CRUD que se llamarán desde el 
	//controller, previa implementación desde otro service	
	
	public List<Modelos> obtenerTodosModelos() throws NotFoundException;

    public Optional<Modelos> obtenerModelosPorId(Long id);

    public Modelos actualizarModelos(Modelos modeloActualizado) throws NotFoundException;
    
    public void anadirModelos (Modelos modelos);

	void eliminarModelos(Long id)throws NotFoundException;
}
