package com.mx.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TANQUE")
public class Tanque {
	@Id
	@Column(name="ID", columnDefinition="NUMBER")
	int id;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR(30)")
	String nombre;
	
	@Column(name="PAIS", columnDefinition= "NVARCHAR(30)")
	String pais;
	
	@Column(name="DANO", columnDefinition="NUMBER")
	double dano;
	
	@Column(name="HP", columnDefinition="NUMBER")
	double hp;
	
	public Tanque() {
		
	};
	
	public Tanque(int id) {
		
	}

	public Tanque(int id, String nombre, String pais, double dano, double hp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.dano = dano;
		this.hp = hp;
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

	public double getDano() {
		return dano;
	}

	public void setDano(double dano) {
		this.dano = dano;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Tanque [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", dano=" + dano + ", hp=" + hp + "]\n";
	}
	
	
}
