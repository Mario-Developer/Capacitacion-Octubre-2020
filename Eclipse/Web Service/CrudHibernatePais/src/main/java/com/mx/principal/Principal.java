package com.mx.principal;

import com.mx.dao.EstadoDao;
import com.mx.dao.PaisDao;
import com.mx.entidades.Estado;
import com.mx.entidades.Pais;

public class Principal {

	public static void main(String[] args) {
		//EstadoDao dao = new EstadoDao();
		PaisDao dao = new PaisDao();
		/*Estado e = new Estado(5, "QRO", 80000, new Pais(1));
		dao.guardar(e);*/
		
		/*Pais pa = new Pais(1);
		Estado es = new Estado(2, "Veracruz, Jalapa", 5000, pa);
		dao.editar(es);*/
		
		System.out.println("Lista de Estados-> "+dao.mostrar());
	}

}
