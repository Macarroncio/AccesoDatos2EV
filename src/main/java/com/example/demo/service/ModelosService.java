/**
 * Pre:---
 * Post: Interfaz de servicio para la entidad "Modelos".
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.dto.ModeloDTO;
import com.example.demo.model.Modelos;

public interface ModelosService {

    /**
     * Pre:---
     * Post: Obtiene todos los modelos.
     */
    public List<Modelos> obtenerTodosModelos() throws NotFoundException;

    /**
     * Pre:---
     * Post: Obtiene una lista de DTOs de modelos.
     */
    List<ModeloDTO> obtenerModelos() throws NotFoundException;

    /**
     * Pre:---
     * Post: Obtiene un modelo por su ID.
     */
    public Optional<Modelos> obtenerModelosPorId(Long id);

    /**
     * Pre:---
     * Post: Actualiza la información de un modelo.
     */
    public Modelos actualizarModelos(Modelos modeloActualizado) throws NotFoundException;

    /**
     * Pre:---
     * Post: Añade un nuevo modelo.
     */
    public void anadirModelos(Modelos modelos);

    /**
     * Pre:---
     * Post: Elimina un modelo por su ID.
     */
    public void eliminarModelos(Long id) throws NotFoundException;
}
