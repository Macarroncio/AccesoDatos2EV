package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Modelos;

public interface ModelosRepository extends JpaRepository <Modelos, Long> {
	//Operaciones CRUD básicas que vienen a través de JpaRepository
}
