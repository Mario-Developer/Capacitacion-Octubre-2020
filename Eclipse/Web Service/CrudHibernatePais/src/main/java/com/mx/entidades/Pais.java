package com.mx.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PAIS")
public class Pais {
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(50)")
	String nombre;
	
	@Column(name="CONTINENTE", columnDefinition="NVARCHAR2(50)")
	String continente;
	
	@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Estado> lista = new ArrayList<Estado>();
	
	public Pais() {
	}
	
	public Pais(int id) {
		this.id = id;
	}

	public Pais(int id, String nombre, String continente) {
		this.id = id;
		this.nombre = nombre;
		this.continente = continente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", continente=" + continente + "]\n";
	}
	
	
	
}
