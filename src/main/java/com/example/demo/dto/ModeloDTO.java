package com.example.demo.dto;

import com.example.demo.model.Marcas;
// esta es la clase del fichero que hace de intermediario entre los datos reales y en donde
// estos tienen que llegar
public class ModeloDTO {

	private Long id;
	private String nombre;
	private Marcas marca;
	
	public ModeloDTO(Long id, Marcas marca, String nombre) {
		this.id=id;
		this.marca=marca;
		this.nombre=nombre;
	}

	// Getters and setters


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Marcas getMarca() {
		return marca;
	}	
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
}

