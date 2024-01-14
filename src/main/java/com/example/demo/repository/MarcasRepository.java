package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Marcas;

public interface MarcasRepository extends JpaRepository <Marcas, Long> {
	//Operaciones CRUD básicas que vienen a través de JpaRepository
}
