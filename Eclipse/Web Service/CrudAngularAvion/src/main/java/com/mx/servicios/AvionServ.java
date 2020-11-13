package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.AvionDao;
import com.mx.entidad.Avion;
import com.mx.general.Estatus;

@Path("Avion")
public class AvionServ {
	AvionDao dao = null;
	Estatus e = null;
	String r = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Avion> mostrar(){
		dao = new AvionDao();
		List<Avion> lista = new ArrayList<Avion>();
		lista = dao.mostar();
		System.out.println("Lista: "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Avion a) {
		dao = new AvionDao();
		e = new Estatus();
		e.setObj(a);
		r = dao.guardar(a);
		if (r.equals("1")) {
			e.setMessage("Guardado");
			e.setRes(r);
		} else {
			e.setMessage("No Guardado");
			e.setRes(r);
		}
		return e;	
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Avion a) {
		dao = new AvionDao();
		e = new Estatus();
		e.setObj(a);
		r = dao.editar(a);
		if (r.equals("1")) {
			e.setMessage("Editado");
			e.setRes(r);
		} else {
			e.setMessage("No editado");
			e.setRes(r);
		}
		return e;		
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Avion a) {
		dao = new AvionDao();
		e = new Estatus();
		e.setObj(a);
		r = dao.eliminar(a);
		if (r.equals("1")) {
			e.setMessage("Aliminado");
			e.setRes(r);
		} else {			
			e.setMessage("No guardado");
			e.setRes(r);
		}
		return e;
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Object buscar(Avion a) {
		dao = new AvionDao();		
		return a = (Avion) dao.buscar(a);
	}
}
