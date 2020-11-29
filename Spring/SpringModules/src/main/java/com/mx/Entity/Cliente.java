package com.mx.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLIENTES")
public class Cliente {
	
	@Id
	@Column (name = "ID", columnDefinition = "INTEGER")
	int id;
	
	@Column (name = "NOMBRE", columnDefinition = "VARCHAR(50)")
	String nombre;
	
	@Column (name = "APP", columnDefinition = "VARCHAR(50)")
	String app;
	
	@Column (name = "APM", columnDefinition = "VARCHAR(50)")
	String apm;
	
	public Cliente() {
		
	}
	
	public Cliente (int id) {
		this.id = id;
	}

	public Cliente(int id, String nombre, String app, String apm) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + "]\n";
	}
	
	
	
}
