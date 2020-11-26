package com.mx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Empresa;
import com.mx.generales.Operaciones;

public class EmpresaDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Televisiones");
	EntityManager em = emf.createEntityManager();
	Empresa e = null;
	String r = null;

	public List mostrar() {
		List <Empresa> list = new ArrayList<Empresa>();
		list = em.createQuery("from Empresa").getResultList();
		return list;
	}

	public String guardar(Object obj) {
		e = (Empresa) obj;
		em.getTransaction().begin();
		try {
			em.persist(e);
			em.getTransaction().commit();
			System.out.println("Objeto guardado");
			r = "1";
		} catch (Exception ex) {
			r = ex.getMessage();
			em.getTransaction().rollback();
			System.out.println("Objeto no guardado");
		}
		return r;
	}

	public String editar(Object obj) {
		e = (Empresa) obj;
		Empresa e2 = new Empresa();
		e2 = em.find(Empresa.class, e.getId());
		em.getTransaction().begin();
		try {
			e2.setNombre(e.getNombre());
			e2.setDireccion(e.getDireccion());
			e2.setClave(e.getClave());
			em.getTransaction().commit();
			System.out.println("Objeto editado");
			r = "1";
		} catch (Exception ex) {
			r = ex.getMessage();
			em.getTransaction().rollback();
			System.out.println("Objeto no editado");
		}
		return r;
	}

	public String eliminar(Object obj) {
		e = (Empresa) obj;
		e = em.find(Empresa.class, e.getId());
		em.getTransaction().begin();
		try {
			em.remove(e);
			em.getTransaction().commit();
			System.out.println("Objeto eliminado");
			r = "1";
		} catch (Exception ex) {
			r = ex.getMessage();
			em.getTransaction().rollback();
			System.out.println("Objeto no eliminado");
		}
		return r;
	}

	public Object buscar(Object obj) {	
		e = (Empresa) obj;
		return e = em.find(Empresa.class, e.getId());
	}
}
