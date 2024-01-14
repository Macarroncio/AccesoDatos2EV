/**
 * Pre:---
 * Post: Clase de entidad que representa la tabla "marcas" en la base de datos.
 */
package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

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
<<<<<<< Updated upstream
    
    @OneToMany(mappedBy = "id_marcas", cascade = CascadeType.ALL, orphanRemoval = true)
=======
    @OneToMany(mappedBy="marcas", cascade=CascadeType.ALL, orphanRemoval = true)
>>>>>>> Stashed changes
    private List<Vehiculos> vehiculos;

    /**
     * Pre:---
     * Post: Obtiene el ID de la marca.
     */
    public Long getId() {
        return id;
    }

    /**
     * Pre:---
     * Post: Establece el ID de la marca.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre:---
     * Post: Obtiene el nombre de la marca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Pre:---
     * Post: Establece el nombre de la marca.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre:---
     * Post: Obtiene la lista de modelos asociados a la marca.
     */
    public List<Modelos> getModelos() {
        return modelos;
    }

    /**
     * Pre:---
     * Post: Establece la lista de modelos asociados a la marca.
     */
    public void setModelos(List<Modelos> modelos) {
        this.modelos = modelos;
    }
}
