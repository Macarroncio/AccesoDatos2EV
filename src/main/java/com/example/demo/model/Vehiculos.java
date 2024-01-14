package com.example.demo.model;

import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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
	@JoinColumn(name = "id_marca", nullable = false)
	private Marcas id_marcas;
	
	@ManyToOne
	@JoinColumn(name = "id_modelo", nullable = false)
	private Modelos id_modelos;
	
	// Getters and setters

	public Long getId() {
		return id;
	}

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "id_marcas", nullable = false)
    private Marcas id_marcas;
    @JoinColumn(name = "id_marca", nullable = false)
    private Marcas marcas;


    @ManyToOne
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelos modelos;
=======
	public void setId(Long id) {
		this.id = id;
	}
	
	public Year getAnio() {
		return anio;
	}
	
	public void setAnio(Year anio) {
		this.anio = anio;
	}

	public String getMatricula() {
		return matricula;
	}
>>>>>>> parent of d94bf38 (Merge branch 'main' of https://github.com/Macarroncio/AccesoDatos2EV)

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNr_bastidor() {
		return nr_bastidor;
	}

	public void setNr_bastidor(String nr_bastidor) {
		this.nr_bastidor = nr_bastidor;
	}

	public Marcas getId_marcas() {
		return id_marcas;
	}

	public void setId_marcas(Marcas id_marcas) {
		this.id_marcas = id_marcas;
	}

	public Modelos getId_modelos() {
		return id_modelos;
	}

<<<<<<< HEAD
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
=======
	public void setId_modelos(Modelos id_modelos) {
		this.id_modelos = id_modelos;
	}
}
>>>>>>> parent of d94bf38 (Merge branch 'main' of https://github.com/Macarroncio/AccesoDatos2EV)
