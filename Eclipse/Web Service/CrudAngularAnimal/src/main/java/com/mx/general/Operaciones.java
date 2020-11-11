package com.mx.general;

import java.util.List;

public interface Operaciones {
	public List mostrar();
	public String guardar(Object obj);
	public String editar(Object Obj);
	public String eliminar(Object Obj);
	public Object buscar(Object Obj);
}
