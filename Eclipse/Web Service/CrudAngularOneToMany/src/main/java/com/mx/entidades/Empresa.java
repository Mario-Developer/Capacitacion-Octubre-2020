package com.mx.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "EMPRESAANGULAR")
public class Empresa {
	@Id
	@Column (name = "ID", columnDefinition = "NUMBER")
	int id;
	
	@Column (name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;
	
	@Column (name = "DIRECCION", columnDefinition = "NVARCHAR2(50)")
	String direccion;
	
	@Column (name = "CLAVE", columnDefinition = "NVARCHAR2(50)")
	String clave;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Television> lista = new ArrayList<Television>();
	
	public Empresa() {
		
	}
	
	public Empresa(int id) {
		this.id = id;
	}

	public Empresa(int id, String nombre, String direccion, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.clave = clave;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", clave=" + clave + "]\n";
	}
	
	
}
