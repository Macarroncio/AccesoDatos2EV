/**
 * Pre:---
 * Post: Interfaz de servicio para la entidad "Vehiculos".
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.example.demo.model.Vehiculos;

public interface VehiculosService {

    /**
     * Pre:---
     * Post: Obtiene todos los vehículos.
     */
    public List<Vehiculos> obtenerTodosVehiculos() throws NotFoundException;

    /**
     * Pre:---
     * Post: Obtiene un vehículo por su ID.
     */
    public Optional<Vehiculos> obtenerVehiculosPorId(Long id);

    /**
     * Pre:---
     * Post: Actualiza la información de un vehículo.
     */
    public Vehiculos actualizarVehiculos(Vehiculos vehiculoActualizado) throws NotFoundException;

    /**
     * Pre:---
     * Post: Añade un nuevo vehículo.
     */
    public void anadirVehiculos(Vehiculos vehiculos);

    /**
     * Pre:---
     * Post: Elimina un vehículo por su ID.
     */
    public void eliminarVehiculos(Long id) throws NotFoundException;
}
