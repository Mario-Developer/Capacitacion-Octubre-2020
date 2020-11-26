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
import com.mx.entidades.Empresa;
import com.mx.generales.Estatus;

@Path("Empresa")
public class EmpresaServ {
	EmpresaDao dao= null;
	Estatus est = null;
	String r = null;

	@GET
	@Path("mostrar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empresa> mostrar() {
		dao = new EmpresaDao();
		List <Empresa> lista = new ArrayList<Empresa>();		
		lista = dao.mostrar();
		return lista;		
	}
	
	@POST
	@Path("guardar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estatus guardar(Empresa e) {
		dao = new EmpresaDao();
		est = new Estatus();
		est.setObj(e);
		r = dao.guardar(e);
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
	public Estatus editar(Empresa e) {
		dao = new EmpresaDao();
		est = new Estatus();
		est.setObj(e);
		r = dao.editar(e);
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
	public Estatus eliminar(Empresa e) {
		dao = new EmpresaDao();
		est = new Estatus();
		est.setObj(e);
		r = dao.eliminar(e);
		if (r.equals("1")) {
			est.setMessage("Recibido y eliminado");
			est.setResp(r);
		} else {
			est.setMessage("No eliminado");
			est.setResp(r);
		}
		return est;
	}
	
	@POST
	@Path("buscar")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Object buscar (Empresa e) {
		dao = new EmpresaDao();
		return e = (Empresa) dao.buscar(e);
	}
}
