package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "NOVIA")
public class Novia {

	@Id
	@Column (name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@Column(name = "APP", columnDefinition = "NVARCHAR2(50)")
	String app;
	
	@Column(name = "APM", columnDefinition = "NVARCHAR2(50)")
	String apm;
	
	@Column(name = "HOBBIE", columnDefinition = "NVARCHAR2(50)")
	String hobbie;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_NOVIO")
	Novio novio;
	
	public Novia() {
		
	}
	
	public Novia(int id) {
		this.id = id;
	}

	public Novia(int id, String nombre, String app, String apm, String hobbie, Novio novio) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.hobbie = hobbie;
		this.novio = novio;
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

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public String getHobbie() {
		return hobbie;
	}

	public void setHobbie(String hobbie) {
		this.hobbie = hobbie;
	}

	public Novio getNovio() {
		return novio;
	}

	public void setNovio(Novio novio) {
		this.novio = novio;
	}

	@Override
	public String toString() {
		return "Novia [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", hobbie=" + hobbie + "]\n";
	}
	
	
}
