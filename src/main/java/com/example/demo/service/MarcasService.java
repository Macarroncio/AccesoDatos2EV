/**
 * Pre:---
 * Post: Interfaz de servicio para la entidad "Marcas".
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.example.demo.model.Marcas;

public interface MarcasService {

    /**
     * Pre:---
     * Post: Obtiene todas las marcas.
     */
    public List<Marcas> obtenerTodasMarcas() throws NotFoundException;

    /**
     * Pre:---
     * Post: Obtiene una marca por su ID.
     */
    public Optional<Marcas> obtenerMarcasPorId(Long id);

    /**
     * Pre:---
     * Post: Actualiza la información de una marca.
     */
    public Marcas actualizarMarca(Marcas marcaActualizada) throws NotFoundException;

    /**
     * Pre:---
     * Post: Añade una nueva marca.
     */
    public void anadirMarcas(Marcas marcas);

    /**
     * Pre:---
     * Post: Elimina una marca por su ID.
     */
    public void eliminarMarcas(Long id) throws NotFoundException;
}
