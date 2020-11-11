package com.mx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO")
public class Estado {
	@Id
	@Column (name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column (name="NOMBRE", columnDefinition="NVARCHAR2(50)")
	String nombre;
	
	@Column (name="HABITANTES", columnDefinition="NUMBER")
	double habitantes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_PAIS")
	Pais pais;
	
	public Estado() {
		
	}
	
	public Estado(int id) {
		
	}

	public Estado(int id, String nombre, double habitantes, Pais pais) {
		this.id = id;
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.pais = pais;
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

	public double getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(double habitantes) {
		this.habitantes = habitantes;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombre=" + nombre + ", habitantes=" + habitantes + ", pais=" + pais + "]\n";
	}
	
	
}
