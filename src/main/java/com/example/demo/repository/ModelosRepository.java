package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Modelos;

public interface ModelosRepository extends JpaRepository <Modelos, Long> {

	List<Modelos> findByMarcasId(Long idMarca);
	
}
