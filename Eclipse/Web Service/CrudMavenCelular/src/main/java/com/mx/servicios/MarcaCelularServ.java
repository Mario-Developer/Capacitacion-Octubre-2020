package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.CelularDao;
import com.mx.dao.MarcaCelularDao;
import com.mx.entidad.Celular;
import com.mx.entidad.MarcaCelular;
import com.mx.general.Estatus;

@Path("MarcaCelular") //http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/mostrar
public class MarcaCelularServ {
	MarcaCelularDao dao = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public List<MarcaCelular> mostrar(){
		dao = new MarcaCelularDao();
		List<MarcaCelular> lista = new ArrayList<MarcaCelular>();
		lista = dao.mostrar();
		System.out.println("lista-> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus insertar(MarcaCelular mc) {
		
		Estatus e = new Estatus();
		e.setObj(mc);
		String r = null;
		dao = new MarcaCelularDao();
		r = dao.guardar(mc);
		
		if(r.equals("1")) {
			e.setMensaje("Guardado");
			e.setRes(r);
			
		}else {
			e.setMensaje("Error");
			e.setRes(r);
		}
		return e;
	}
	
	@POST //Anotaciones
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(MarcaCelular mc) {
		
		Estatus e = new Estatus();
		e.setObj(mc);
		
		String r = null;
		dao = new MarcaCelularDao();
		r = dao.eliminar(mc);
		
		if(r.equals("1")) {
			e.setMensaje("Eliminar");
			e.setRes(r);
			
		}else {
			e.setMensaje("Error");
			e.setRes(r);
		}
		return e;
	}
	
	@POST //Anotaciones
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public MarcaCelular buscar(MarcaCelular mc) {
		dao = new MarcaCelularDao();
		mc = (MarcaCelular) dao.buscar(mc);
		System.out.println("Cel encontrado: "+mc);
		return mc;
	}
	
	@POST //Anotaciones
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(MarcaCelular mc) {
		
		Estatus e = new Estatus();
		e.setObj(mc);
		
		String r = null;
		dao = new MarcaCelularDao();
		r=dao.editar(mc);
		
		if(r.equals("1")) {
			e.setMensaje("Editado");
			e.setRes(r);
			
		}else {
			e.setMensaje("Error");
			e.setRes(r);
		}
		return e;
	}
	
}
