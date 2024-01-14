/**
 * Pre:---
 * Post: Clase de entidad que representa la tabla "modelos" en la base de datos.
 */
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Modelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marcas;

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
     * Post: Obtiene la marca asociada al modelo.
     */
    public Marcas getMarca() {
        return marcas;
    }

    /**
     * Pre:---
     * Post: Establece la marca asociada al modelo.
     */
    public void setMarca(Marcas marcas) {
        this.marcas = marcas;
    }
}
