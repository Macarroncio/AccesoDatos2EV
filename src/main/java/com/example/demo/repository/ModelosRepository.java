/**
 * Pre:---
 * Post: Interfaz de repositorio que extiende JpaRepository para realizar operaciones CRUD en la entidad "Modelos".
 */
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Modelos;

public interface ModelosRepository extends JpaRepository<Modelos, Long> {

    /**
     * Pre:---
     * Post: Busca y devuelve una lista de modelos asociados a una marca específica por su ID.
     */
    List<Modelos> findByMarcasId(Long idMarca);
}
