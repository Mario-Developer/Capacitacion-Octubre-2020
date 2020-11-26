package com.mx.general;

import java.util.List;

public interface Operaciones {
	public List mostrar();
	public void guardar(Object obj);
	public void editar(Object obj);
	public void eliminar(Object obj);
	public Object buscar(Object obj);
}
