package com.mx.entidad;
public class Dueno {
	int id;
	String nombre;
	String app;
	String pueblo;
	
	public Dueno() {
		
	}
	
	public Dueno(int id) {
		this.id = id;
	}

	public Dueno(int id, String nombre, String app, String pueblo) {
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.pueblo = pueblo;
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

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	@Override
	public String toString() {
		return "Dueno [id=" + id + ", nombre=" + nombre + ", app=" + app + ", pueblo=" + pueblo + "]\n";
	}
	
	
}
