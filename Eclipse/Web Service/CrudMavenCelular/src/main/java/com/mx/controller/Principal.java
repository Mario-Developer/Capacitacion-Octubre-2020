package com.mx.controller;

import com.mx.dao.CelularDao;
import com.mx.entidad.Celular;

public class Principal {
	public static void main(String[] args) {
		CelularDao dao = new CelularDao();
		//Celular cel = new Celular(2, "s10 plus", "samsung", 20000);
		//dao.guardar(cel);
		
		Celular cel = new Celular(2, "s20", "samsung", 18000);
		dao.editar(cel);
		
		System.out.println("Datos: "+dao.mostrar());
	}
}
