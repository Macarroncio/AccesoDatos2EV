/**
 * Pre:---
 * Post: Interfaz de repositorio que extiende JpaRepository para realizar operaciones CRUD en la entidad "Marcas".
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Marcas;

public interface MarcasRepository extends JpaRepository<Marcas, Long> {
    // Operaciones CRUD básicas proporcionadas por JpaRepository
}
