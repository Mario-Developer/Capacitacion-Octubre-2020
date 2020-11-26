package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "PROFESORES")
public class Profesor {
	@Id
	@Column (name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column (name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@Column (name = "APP", columnDefinition = "NVARCHAR2(50)")
	String app;
	
	@Column (name = "MATRICULA", columnDefinition = "NVARCHAR2(50)")
	String matricula;
	
	@OneToMany (mappedBy = "profesor", cascade = CascadeType.ALL)
	private List<Clase> lista = new ArrayList<Clase>();
	
	public Profesor() {
		
	}
	
	public Profesor(int id) {
		this.id = id;
	}		

	public Profesor(int id, String nombre, String app, String matricula) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.matricula = matricula;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", app=" + app + ", matricula=" + matricula + "]/n";
	}
	
	
}

