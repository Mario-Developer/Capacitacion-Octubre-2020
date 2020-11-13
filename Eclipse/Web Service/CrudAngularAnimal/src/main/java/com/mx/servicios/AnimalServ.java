package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.AnimalDao;
import com.mx.entidades.Animal;
import com.mx.general.Estatus;

@Path("Animal")
public class AnimalServ {
	AnimalDao dao = null;
	Estatus e = null;
	String r = null;

	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Animal> mostrar() {		
		dao = new AnimalDao();
		List <Animal> lista = new ArrayList<Animal>();
		lista = dao.mostrar();
		System.out.println("Lista: "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Animal a) {
		e = new Estatus();
		dao = new AnimalDao();
		e.setObj(a);
		r = dao.guardar(a);
		if (r.equals("1")) {
			e.setMensaje("Guardado");
			e.setRes(r);
		} else {
			e.setMensaje("No guardado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Animal a) {
		e = new Estatus();
		dao = new AnimalDao();
		e.setObj(a);
		r = dao.editar(a);
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
	public Estatus eliminar(Animal a) {
		e = new Estatus();
		dao = new AnimalDao();
		e.setObj(a);
		r = dao.eliminar(a);
		if (r.equals("1")) {
			e.setMensaje("Eliminado");
			e.setRes(r);
		} else {
			e.setMensaje("No eliminado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Animal buscar(Animal a) {
		dao = new AnimalDao();
		return a = (Animal) dao.buscar(a);
	}
}
