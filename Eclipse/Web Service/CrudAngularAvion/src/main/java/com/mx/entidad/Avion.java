package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVION")
public class Avion {
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER")
	int id;
	@Column(name = "MODELO", columnDefinition = "NVARCHAR2(50)")
	String modelo;
	
	@Column(name = "MARCA", columnDefinition = "NVARCHAR2(50)")
	String marca;
	
	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	double precio;
	
	public Avion() {
		
	}
	
	public Avion (int id) {
		
	}

	public Avion(int id, String modelo, String marca, double precio) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Avion [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + "]\n";
	}
	
	
	
}
