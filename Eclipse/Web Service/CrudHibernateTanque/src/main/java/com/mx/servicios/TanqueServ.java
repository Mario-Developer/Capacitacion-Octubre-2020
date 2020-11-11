package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.TanqueDao;
import com.mx.entidades.Tanque;
import com.mx.generales.Estatus;

@Path("Tanque") //http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque
public class TanqueServ {
	TanqueDao dao = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tanque> mostrar() {
		dao = new TanqueDao();
		List<Tanque> lista = new ArrayList<Tanque>();
		lista = dao.mostrar();
		System.out.println("Lista-> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Tanque t) {
		Estatus e = new Estatus();
		e.setObj(t);
		String r = null;
		dao = new TanqueDao();
		r=dao.guardar(t);
		if(r.equals("1")) {
			e.setMensaje("Guardado");
			e.setRes(r);
		}else {
			e.setMensaje("No guardado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Tanque t) {
		Estatus e = new Estatus();
		e.setObj(t);
		String r = null;
		dao = new TanqueDao();
		r = dao.editar(t);
		
		if (r.equals("1")) {
			e.setMensaje("Editado");
			e.setRes(r);
		} else {
			e.setMensaje("No editado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Tanque t) {
		Estatus e = new Estatus();
		e.setObj(t);
		String r = null;
		dao = new TanqueDao();
		r = dao.eliminar(t);
		
		if (r.equals("1")) {
			e.setMensaje("eliminado");
			e.setRes(r);
		} else {
			e.setMensaje("No Eliminado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST 
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Tanque buscar(Tanque t) {
		dao = new TanqueDao();
		t = (Tanque) dao.buscar(t);
		System.out.println("Tanque encontrado: "+t);
		return t;
	}
	
	@POST	
	@Path("buscarnombre")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tanque> buscarNombre(Tanque t){
		dao = new TanqueDao();
		List<Tanque> lista = new ArrayList<Tanque>();
		lista = dao.buscarNombre(t);
		return lista;
	}
}
