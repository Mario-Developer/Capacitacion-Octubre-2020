package com.mx.CrudSpringHibernate.general;

import java.util.List;

public interface Operaciones {
	public void guardar(Object obj);
	public void editar(Object obj);
	public void eliminar(Object obj);
	public List mostrar();
	public Object buscar(Object obj);
}
