package com.mx.entidad;

public class Pokemon {
	int id;
	String nombre;
	String tipo;
	String ataque;
	Dueno dueno;
	
	public Pokemon() {
		
	}
	
	public Pokemon(int id) {
		
	}

	public Pokemon(int id, String nombre, String tipo, String ataque, Dueno dueno) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataque = ataque;
		this.dueno = dueno;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}

	public Dueno getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", ataque=" + ataque + ", dueno=" + dueno
				+ "]\n";
	}
	
	
}
