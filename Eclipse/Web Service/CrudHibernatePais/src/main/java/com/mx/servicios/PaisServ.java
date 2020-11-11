package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.mx.dao.PaisDao;
import com.mx.entidades.Pais;
import com.mx.generales.Estatus;

@Path("Pais")
public class PaisServ {
	PaisDao dao = new PaisDao();
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pais> mostrar(){
		List<Pais> lista = new ArrayList<Pais>();		
		lista = dao.mostrar();
		System.out.println("Lista -> "+lista);
		return lista;		
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Pais p) {
		Estatus est = new Estatus();
		est.setObj(p);
		String r = null;
		r = dao.guardar(p);
		if (r.equals("1")) {
			est.setMensaje("Guardado");
			est.setRes(r);
		} else {
			est.setMensaje("No guardado");
			est.setRes(r);
		}
		return est;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Pais p) {
		Estatus est = new Estatus();
		est.setObj(p);
		String r = null;
		r = dao.editar(p);
		if (r.equals("1")) {
			 est.setMensaje("Editado");
			 est.setRes(r);
		} else {
			est.setMensaje("No editado");
			est.setRes(r);
		}
		return est;		
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Pais buscar(Pais p) {
		dao = new PaisDao();
		p = (Pais) dao.buscar(p);
		System.out.println("Pais encontrado: "+p);
		return p;
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Pais p) {
		Estatus est = new Estatus();
		est.setObj(p);
		String r = null;
		dao = new PaisDao();
		r = dao.eliminar(p);
		if (r.equals("1")) {
			est.setMensaje("eliminado");
			est.setRes(r);
		} else {
			est.setMensaje("No Eliminado");
			est.setRes(r);
		}
		return est;
	}
	
	@POST
	@Path("buscarNombre")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List buscarNombre(Pais p) {
		dao = new PaisDao();
		List <Pais> lista = dao.buscarNombre(p);
		System.out.println("Estado encontrado: "+lista);
		return lista;
	}
}
