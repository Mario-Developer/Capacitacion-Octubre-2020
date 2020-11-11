package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.EstadoDao;
import com.mx.entidades.Estado;
import com.mx.generales.Estatus;

@Path("Estado")
public class EstadoServ {
	EstadoDao dao = new EstadoDao();
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Estado> mostrar() {
		List<Estado> lista = new ArrayList<Estado>();
		lista = dao.mostrar();
		System.out.println("Lista -> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Estado e) {
		Estatus est = new Estatus();
		est.setObj(e);
		String r = null;
		r = dao.guardar(e);
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
	public Estatus editar(Estado e) {
		Estatus est = new Estatus();
		est.setObj(e);
		String r = null;
		r = dao.editar(e);
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
	public Estado buscar(Estado e) {
		dao = new EstadoDao();
		e = (Estado) dao.buscar(e);
		System.out.println("Estado encontrado: "+e);
		return e;
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Estado e) {
		Estatus est = new Estatus();
		est.setObj(e);
		String r = null;
		dao = new EstadoDao();
		r = dao.eliminar(e);
		
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
	public List buscarNombre(Estado e) {
		dao = new EstadoDao();
		List <Estado> lista = dao.buscarNombre(e);
		System.out.println("Estado encontrado: "+lista);
		return lista;
	}
}
