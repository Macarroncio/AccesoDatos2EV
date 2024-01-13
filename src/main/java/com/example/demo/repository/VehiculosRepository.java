package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vehiculos;

public interface VehiculosRepository extends JpaRepository<Vehiculos, Long>{
	// Operaciones basicas heredadas de JpaRepository.
}
