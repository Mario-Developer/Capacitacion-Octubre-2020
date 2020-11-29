package com.mx.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mx.Entity.Cliente;
import com.mx.Interfaces.JPAInterface;
import com.mx.dao.ClienteDAO;

@Controller
@RequestMapping ("/test")
public class Controlador {
	
	@Autowired
	private JPAInterface inter;
	
	@GetMapping("/mostrar")
	public String mostrar(Model model) {
		List <Cliente> lista = inter.findAll();
		model.addAttribute("cliente", lista);
		return "index";
	}
	
}
