package com.mx.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Empresa;
import com.mx.entidades.Television;
import com.mx.generales.Operaciones;

public class TelevisionDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Televisiones");
	EntityManager em = emf.createEntityManager();
	Empresa e = null;
	Television t = null;
	String r = null;

	public List mostrar() {
		List <Television> lista = new ArrayList<Television>();
		lista = em.createQuery("from Television").getResultList();
		return lista;
	}

	public String guardar(Object obj) {
		t = (Television) obj;
		System.out.println("Empresa encontrada: "+ t.getEmpresa().getId());
		e = em.find(Empresa.class, t.getEmpresa().getId());		
		em.getTransaction().begin();
		try {
			em.persist(t);
			t.setEmpresa(e);
			em.getTransaction().commit();
			r = "1";
			System.out.println("Objeto guardado");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			r = ex.getMessage();
			System.out.println("Objeto noguardado");
		}
		return r;
	}

	public String editar(Object obj) {
		t = (Television) obj;
		Television t2 = em.find(Television.class, t.getId());
		e = em.find(Empresa.class, t.getEmpresa().getId());
		em.getTransaction().begin();
		try {
			t2.setModelo(t.getModelo());
			t2.setMarca(t.getMarca());
			t2.setPrecio(t.getPrecio());
			t2.setEmpresa(e);
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
		t = (Television) obj;
		t = em.find(Television.class, t.getId());
		em.getTransaction().begin();
		try {
			em.remove(t);
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
		t = (Television) obj;
		return t = em.find(Television.class, t.getId());
	}

}
