package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "NOVIO")
public class Novio {
	@Id
	@Column(name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@Column(name = "APP", columnDefinition = "NVARCHAR2(50)")
	String app;
	
	@Column(name = "APM", columnDefinition = "NVARCHAR2(50)")
	String apm;
	
	@Column(name = "PROFESION", columnDefinition = "NVARCHAR2(50)")
	String profesion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NOVIA")
	Novia novia;
	
	public Novio() {
		
	}
	
	public Novio (int id) {
		this.id = id;
	}

	public Novio(int id, String nombre, String app, String apm, String profesion, Novia novia) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.profesion = profesion;
		this.novia = novia;
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

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public Novia getNovia() {
		return novia;
	}

	public void setNovia(Novia novia) {
		this.novia = novia;
	}

	@Override
	public String toString() {
		String salida = null;
		if (novia == null) {
			salida = "Novio [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", profesion=" + profesion + "]\n";
		}else {
			salida = "Novio [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", profesion=" + profesion + ", novia=" + novia + "]\n";
		}
		return salida;
	}
	
	
}
