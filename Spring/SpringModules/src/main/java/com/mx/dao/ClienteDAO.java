package com.mx.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mx.Entity.Cliente;
import com.mx.Interfaces.CRUDInterface;
import com.mx.Interfaces.JPAInterface;

public class ClienteDAO {
	
	Cliente cliente = new Cliente();
	
	@Autowired
	private CRUDInterface crudinterface;
	
	@Autowired
	private JPAInterface jpainterface;
	
	public List<Cliente> mostrar () {
		
		return (List<Cliente>) crudinterface.findAll();
		
	}
	
}
