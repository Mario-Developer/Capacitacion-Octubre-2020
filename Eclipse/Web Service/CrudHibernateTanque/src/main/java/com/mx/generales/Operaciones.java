package com.mx.generales;
import java.util.List;

public interface Operaciones {
	public String guardar(Object obj);
	public String editar(Object obj);
	public String eliminar(Object obj);
	public Object buscar(Object obj);
	public List buscarNombre(Object obj);
	public List mostrar();
}
