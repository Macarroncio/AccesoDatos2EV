package com.example.demo.model;

<<<<<<< HEAD
import java.util.List;

import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
>>>>>>> parent of d94bf38 (Merge branch 'main' of https://github.com/Macarroncio/AccesoDatos2EV)

@Entity
public class Modelos {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marcas;
    @OneToMany(mappedBy="modelos", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculos> vehiculos;

    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marcas getMarca() {
        return marcas;
    }

    public void setMarca(Marcas marcas) {
        this.marcas = marcas;
    }
}


