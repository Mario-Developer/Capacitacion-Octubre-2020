package com.mx.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "CLASES")
public class Clase {
	
	@Column (name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "ID_ALUMNO")
	Alumno alumno;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "ID_PROFESOR")
	Profesor profesor;

	public Clase() {
		
	}

	public Clase(String nombre, Alumno alumno, Profesor profesor) {		
		this.nombre = nombre;
		this.alumno = alumno;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Clase [nombre=" + nombre + ", alumno=" + alumno + ", profesor=" + profesor + "]\n";
	}
	
	
}
