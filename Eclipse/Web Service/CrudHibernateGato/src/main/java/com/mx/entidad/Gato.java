package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GATO")
public class Gato {
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(20)")
	String nombre;
	
	@Column(name="GENERO", columnDefinition="NVARCHAR2(10)")
	String genero;
	
	@Column(name="EDAD", columnDefinition="NUMBER")
	int edad;
	
	public Gato() {
		
	}
	
	public Gato(int id) {
		this.id = id;
	}
	
	public Gato(int id, String nombre, String genero, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Gato [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + "]\n";
	}
	
	
}
