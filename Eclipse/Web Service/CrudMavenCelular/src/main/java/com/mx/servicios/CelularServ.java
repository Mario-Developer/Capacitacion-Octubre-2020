package com.mx.servicios;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.CelularDao;
import com.mx.entidad.Celular;
import com.mx.general.Estatus;

@Path("Celular")
public class CelularServ {
	CelularDao dao = null;
	//http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/mostrar
	//ruta es de la aplicacion/ es del we.xml /path de la clase/ path del metodo
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	
	public List<Celular> mostrar(){
		dao = new CelularDao();
		List<Celular> lista = new ArrayList<Celular>();
		lista = dao.mostrar();
		System.out.println("lista->"+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus insertar(Celular cel) {
		
		Estatus e = new Estatus();
		e.setObj(cel);
		String r = null;
		dao = new CelularDao();
		r=dao.guardar(cel);
		
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
	public Estatus eliminar(Celular cel) {
		
		Estatus e = new Estatus();
		e.setObj(cel);
		
		String r = null;
		dao = new CelularDao();
		r=dao.eliminar(cel);
		
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
	public Celular buscar(Celular cel) {
		dao = new CelularDao();
		cel = (Celular) dao.buscar(cel);
		System.out.println("Cel encontrado: "+cel);
		return cel;
	}
	
	@POST //Anotaciones
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Celular cel) {
		
		Estatus e = new Estatus();
		e.setObj(cel);
		
		String r = null;
		dao = new CelularDao();
		r=dao.editar(cel);
		
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
