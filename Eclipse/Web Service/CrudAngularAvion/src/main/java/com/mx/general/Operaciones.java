package com.mx.general;

import java.util.List;

import com.mx.entidad.Avion;

public interface Operaciones {
	public String guardar(Object obj);
	public String editar(Object obj);
	public String eliminar(Object obj);
	public List<Avion> mostar();
	public Object buscar(Object obj);
}
