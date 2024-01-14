/**
 * Pre:---
 * Post: Clase de entidad que representa la tabla "vehiculos" en la base de datos.
 */
package com.example.demo.model;

import java.time.Year;

import jakarta.persistence.*;

@Entity
public class Vehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private int kilometros;
    private String color;
    private String nr_bastidor;
    private Year anio;

    @ManyToOne
    @JoinColumn(name = "id_marcas", nullable = false)
    private Marcas id_marcas;
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marcas;


    @ManyToOne
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelos modelos;

    /**
     * Pre:---
     * Post: Obtiene el ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Pre:---
     * Post: Establece el ID del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre:---
     * Post: Obtiene el año del vehículo.
     */
    public Year getAnio() {
        return anio;
    }

    /**
     * Pre:---
     * Post: Establece el año del vehículo.
     */
    public void setAnio(Year anio) {
        this.anio = anio;
    }

    /**
     * Pre:---
     * Post: Obtiene la matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Pre:---
     * Post: Establece la matrícula del vehículo.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Pre:---
     * Post: Obtiene los kilómetros del vehículo.
     */
    public int getKilometros() {
        return kilometros;
    }

    /**
     * Pre:---
     * Post: Establece los kilómetros del vehículo.
     */
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Pre:---
     * Post: Obtiene el color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Pre:---
     * Post: Establece el color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Pre:---
     * Post: Obtiene el número de bastidor del vehículo.
     */
    public String getNr_bastidor() {
        return nr_bastidor;
    }

    /**
     * Pre:---
     * Post: Establece el número de bastidor del vehículo.
     */
    public void setNr_bastidor(String nr_bastidor) {
        this.nr_bastidor = nr_bastidor;
    }

    /**
     * Pre:---
     * Post: Obtiene la marca del vehículo.
     */
    public Marcas getMarcas() {
        return marcas;
    }

    /**
     * Pre:---
     * Post: Establece la marca del vehículo.
     */
    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    /**
     * Pre:---
     * Post: Obtiene el modelo del vehículo.
     */
    public Modelos getModelos() {
        return modelos;
    }

    /**
     * Pre:---
     * Post: Establece el modelo del vehículo.
     */
    public void setModelos(Modelos modelos) {
        this.modelos = modelos;
    }
}
