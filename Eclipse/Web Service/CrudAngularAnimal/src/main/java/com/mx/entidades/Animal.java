package com.mx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMALANGULAR")
public class Animal {
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2(50)")
	String nombre;
	
	@Column (name="TIPO", columnDefinition="NVARCHAR2(50)")
	String tipo;
	
	@Column(name="EDAD", columnDefinition="NUMBER")
	int edad;
	
	public Animal() {		
	}
	
	public Animal(int id) {
		this.id = id;
	}

	public Animal(int id, String nombre, String tipo, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", edad=" + edad + "]\n";
	}
	
	
}
