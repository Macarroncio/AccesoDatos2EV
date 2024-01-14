/**
 * Pre:---
 * Post: Clase DTO (Data Transfer Object) que actúa como intermediario entre los datos reales y su representación en la interfaz.
 */
package com.example.demo.dto;

import com.example.demo.model.Marcas;

public class ModeloDTO {

    private Long id;
    private String nombre;
    private Marcas marca;

    public ModeloDTO(Long id, Marcas marca, String nombre) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
    }

    /**
     * Pre:---
     * Post: Obtiene el nombre del modelo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Pre:---
     * Post: Establece el nombre del modelo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre:---
     * Post: Obtiene el ID del modelo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Pre:---
     * Post: Establece el ID del modelo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre:---
     * Post: Obtiene la marca asociada al modelo.
     */
    public Marcas getMarca() {
        return marca;
    }

    /**
     * Pre:---
     * Post: Establece la marca asociada al modelo.
     */
    public void setMarca(Marcas marca) {
        this.marca = marca;
    }
}
