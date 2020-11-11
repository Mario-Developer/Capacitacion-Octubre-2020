package com.mx.entidad;

public class MarcaCelular {
	int id;
	String nombre;
	String pais;
	String slogan;
	
	public MarcaCelular() {
		
	}
	
	public MarcaCelular(int id) {
		this.id = id; 
	}

	public MarcaCelular(int id, String nombre, String pais, String slogan) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.slogan = slogan;
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

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Override
	public String toString() {
		return "MarcaCelular [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", slogan=" + slogan + "]\n";
	}
	
	
}
