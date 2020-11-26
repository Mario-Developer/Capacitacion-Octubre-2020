package com.mx.CrudSpringHibernate.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPOSFUT")
public class Equipo {
	
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@Column(name = "PAIS", columnDefinition = "NVARCHAR2(50)")
	String pais;
	
	@Column(name = "LIGA", columnDefinition = "NVARCHAR2(50)")
	String liga;
	
	@Column(name = "TROFEOS", columnDefinition = "NUMBER")
	int trofeos;
	
	public Equipo() {
	}
	
	public Equipo(int id) {
		this.id = id;
	}

	public Equipo(int id, String nombre, String pais, String liga, int trofeos) {
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.liga = liga;
		this.trofeos = trofeos;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLiga() {
		return liga;
	}

	public void setLiga(String liga) {
		this.liga = liga;
	}

	public int getTrofeos() {
		return trofeos;
	}

	public void setTrofeos(int trofeos) {
		this.trofeos = trofeos;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", liga=" + liga + ", trofeos=" + trofeos
				+ "]\n";
	}
	
	
}
