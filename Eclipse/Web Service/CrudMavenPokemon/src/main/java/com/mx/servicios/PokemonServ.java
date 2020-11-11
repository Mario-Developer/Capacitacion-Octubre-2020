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
import com.mx.dao.PokemonDao;
import com.mx.entidad.Dueno;
import com.mx.entidad.Pokemon;
import com.mx.general.Estatus;

@Path("Pokemon")
public class PokemonServ {
	PokemonDao dao = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Pokemon> mostrar(){
		dao = new PokemonDao();
		List<Pokemon> lista = new ArrayList<Pokemon>();
		lista = dao.mostrar();
		System.out.println("Lista ->"+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Pokemon pkm) {
		Estatus e = new Estatus();
		e.setObj(pkm);
		String r = null;
		dao = new PokemonDao();
		r=dao.guardar(pkm);
		
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
	public Estatus eliminar(Pokemon pkm) {
		
		Estatus e = new Estatus();
		e.setObj(pkm);
		
		String r = null;
		dao = new PokemonDao();
		r=dao.eliminar(pkm);
		
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
	public Pokemon buscar(Pokemon pkm) {
		dao = new PokemonDao();
		pkm = (Pokemon) dao.buscar(pkm);
		System.out.println("Pokemon encontrado: "+pkm);
		return pkm;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Pokemon pkm) {
		
		Estatus e = new Estatus();
		e.setObj(pkm);
		
		String r = null;
		dao = new PokemonDao();
		r=dao.editar(pkm);
		
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
