package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "marcas", uniqueConstraints = {
@UniqueConstraint(columnNames = "nombre")
})
public class Marcas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    @OneToMany(mappedBy = "marcas", cascade = CascadeType.ALL)
    private List<Modelos> modelos;
    
    @OneToMany(mappedBy="marcas", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Vehiculos> vehiculos;

    // Getters and setters

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
}