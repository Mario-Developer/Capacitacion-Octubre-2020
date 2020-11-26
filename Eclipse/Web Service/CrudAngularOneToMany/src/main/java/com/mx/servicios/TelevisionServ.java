package com.mx.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.EmpresaDao;
import com.mx.dao.TelevisionDao;
import com.mx.entidades.Empresa;
import com.mx.entidades.Television;
import com.mx.generales.Estatus;

@Path("Television")
public class TelevisionServ {
	TelevisionDao dao = new TelevisionDao();
	Estatus est = new Estatus();
	String r = null;
	
	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Television> mostrar() {
		List <Television> lista = new ArrayList<Television>();		
		lista = dao.mostrar();
		return lista;		
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Television t) {
		est.setObj(t);
		System.out.println("Objecto recibido en servicio: "+t);
		r = dao.guardar(t);
		if (r.equals("1")) {
			est.setMessage("Recibido y guardado");
			est.setResp(r);
		} else {
			est.setMessage("No guardado");
			est.setResp(r);
		}
		return est;
	}
	
	@POST
	@Path("editar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus editar(Television t) {
		est.setObj(t);
		r = dao.editar(t);
		if (r.equals("1")) {
			est.setMessage("Recibido y editado");
			est.setResp(r);
		} else {
			est.setMessage("No editado");
			est.setResp(r);
		}
		return est;
	}
	
	@POST
	@Path("eliminar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus eliminar(Television t) {
		est.setObj(t);
		r = dao.eliminar(t);
		if (r.equals("1")) {
			est.setMessage("Recibido y editado");
			est.setResp(r);
		} else {
			est.setMessage("No editado");
			est.setResp(r);
		}
		return est;
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Object buscar (Television t) {
		t = (Television) dao.buscar(t);
		return t;
	}
}
