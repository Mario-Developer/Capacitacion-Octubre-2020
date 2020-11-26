package com.mx.generales;

import java.util.List;

public interface Operaciones {
	public List mostrar();
	public String guardar(Object obj);
	public String editar (Object obj);
	public String eliminar(Object obj);
	public Object buscar(Object obj);
}
