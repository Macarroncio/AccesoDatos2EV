/**
 * Pre:---
 * Post: Interfaz de repositorio que extiende JpaRepository para realizar operaciones CRUD en la entidad "Vehiculos".
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Vehiculos;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Long> {
    // Operaciones CRUD básicas proporcionadas por JpaRepository
}
