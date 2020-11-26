package com.mx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "TELEVISIONANGULAR")
public class Television {
	
	@Id
	@Column (name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column (name = "MODELO", columnDefinition = "NVARCHAR2(50)")
	String modelo;
	
	@Column (name = "MARCA", columnDefinition = "NVARCHAR2(50)")
	String marca;
	
	@Column (name = "PRECIO", columnDefinition = "NUMBER")
	double precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_EMPRESA")
	Empresa empresa;
	
	public Television() {
		
	}
	
	public Television(int id) {
		this.id = id;
	}

	public Television(int id, String modelo, String marca, double precio, Empresa empresa) {
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.empresa = empresa;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Television [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", empresa="
				+ empresa + "]\n";
	}
	
	
}
