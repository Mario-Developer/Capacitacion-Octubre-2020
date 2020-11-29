package com.mx.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Entity.Cliente;
import com.mx.Interfaces.JPAInterface;
import com.mx.dao.ClienteDAO;

@RestController
@RequestMapping ("/cliente")
public class ClienteRest {
	
	@Autowired
	private JPAInterface inter;
	
	@GetMapping("/mostrar")
	public List<Cliente> mostrar(){
		return inter.findAll();
	}
}
