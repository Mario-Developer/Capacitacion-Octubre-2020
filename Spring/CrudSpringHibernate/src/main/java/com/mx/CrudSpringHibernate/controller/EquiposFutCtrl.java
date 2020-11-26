package com.mx.CrudSpringHibernate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mx.CrudSpringHibernate.dao.EquipoDao;
import com.mx.CrudSpringHibernate.entidad.Equipo;

@Controller
@RequestMapping("/Equipo")
public class EquiposFutCtrl {

	EquipoDao dao = null;
	Equipo equipo = null;
	
	@GetMapping(path = {"/inicio", "/"})
	public ModelAndView mostrar() {
		dao = new EquipoDao();
		List<Equipo> lista = dao.mostrar();
		ModelAndView view = new ModelAndView("indexEquipos");
		view.addObject("listEquipos", lista);
		return view;
	}
	
	@GetMapping("/altaEquipo")
	public ModelAndView altaEquipo() {		
		return new ModelAndView ("altaEquipo").addObject("equipo", new Equipo());
	}
	
	@GetMapping("/eliminarEquipo")
	public ModelAndView eliminarEquipo() {		
		return new ModelAndView ("eliminarEquipo").addObject("equipo", new Equipo());
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardar(Equipo equipo) {		
		dao = new EquipoDao();		
		System.out.println("Equipo a guardar: "+equipo);
		dao.guardar(equipo);
		
		List<Equipo> lista = dao.mostrar();
		System.out.println("Lista: "+lista);
		ModelAndView view = new ModelAndView("indexEquipos");
		view.addObject("listEquipos", lista);
		return view;		
	}
	
	@PostMapping("/eliminar")
	public ModelAndView eliminar(Equipo equipo) {
		dao = new EquipoDao();
		dao.eliminar(equipo);
		
		List<Equipo> lista = dao.mostrar();
		System.out.println("Lista: "+lista);
		ModelAndView view = new ModelAndView("indexEquipos");
		view.addObject("listEquipos", lista);
		return view;
	}
	
	@GetMapping("editarEquipo")
	public ModelAndView editarEquipo(@RequestParam(name = "id") String id) {
		dao = new EquipoDao();
		System.out.println("Id: "+id);
		equipo = new Equipo(Integer.parseInt(id));
		equipo = (Equipo) dao.buscar(equipo);
		return new ModelAndView("editarEquipo").addObject("equipo", equipo);		
	}
	
	@PostMapping(path = "/editar")
	public ModelAndView editar(Equipo equipo) {
		dao = new EquipoDao();
		dao.editar(equipo);
		
		List<Equipo> lista = dao.mostrar();
		System.out.println("Lista: "+lista);
		ModelAndView view = new ModelAndView("indexEquipos");
		view.addObject("listEquipos", lista);
		return view;
	}
}
