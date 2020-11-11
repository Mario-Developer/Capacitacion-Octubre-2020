package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.DuenoDao;
import com.mx.entidad.Dueno;
import com.mx.general.Estatus;

@Path ("Dueno") //http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/mostrar
public class DuenoServ {
	DuenoDao dao = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Dueno> mostrar(){
		dao = new DuenoDao();
		List<Dueno> lista = new ArrayList<Dueno>();
		lista = dao.mostrar();
		System.out.println("Lista -> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Dueno d) {
		Estatus e = new Estatus();
		e.setObj(d);
		String r = null;
		dao = new DuenoDao();
		r=dao.guardar(d);
		
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
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Dueno d) {
		
		Estatus e = new Estatus();
		e.setObj(d);
		
		String r = null;
		dao = new DuenoDao();
		r=dao.eliminar(d);
		
		if(r.equals("1")) {
			e.setMensaje("Eliminar");
			e.setRes(r);
			
		}else {
			e.setMensaje("Error");
			e.setRes(r);
		}
		return e;
	}
	
	@POST 
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Dueno buscar(Dueno d) {
		dao = new DuenoDao();
		d = (Dueno) dao.buscar(d);
		System.out.println("Dueño encontrado: "+d);
		return d;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Dueno d) {
		
		Estatus e = new Estatus();
		e.setObj(d);
		
		String r = null;
		dao = new DuenoDao();
		r=dao.editar(d);
		
		if(r.equals("1")) {
			e.setMensaje("Editado");
			e.setRes(r);
			
		}else {
			e.setMensaje("No editado");
			e.setRes(r);
		}
		return e;
	}
}
