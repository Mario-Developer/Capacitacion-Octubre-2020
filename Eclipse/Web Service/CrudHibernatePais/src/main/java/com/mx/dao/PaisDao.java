package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Pais;
import com.mx.generales.Estatus;
import com.mx.generales.Operaciones;

public class PaisDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Regiones");
	EntityManager em = emf.createEntityManager();
	Pais p = null;
	
	public String guardar(Object obj) {
		p = (Pais) obj;
		em.getTransaction().begin();
		String r = null;
		try {
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Se guardó correctamente");
			r="1";
		} catch (Exception ex) {
			r = ex.getMessage();
			em.getTransaction().rollback();
			System.out.println("Error al guardar-> "+ex.getMessage());
		}
		return r;
	}

	public String editar(Object obj) {
		p = (Pais) obj;		
		Pais pbd = em.find(Pais.class, p.getId());		
		String r = null;
		em.getTransaction().begin();
		try {
			pbd.setNombre(p.getNombre());
			pbd.setContinente(p.getContinente());
			em.getTransaction().commit();
			System.out.println("Se editó el pais-> "+p);
			r = "1";
		} catch (Exception ex) {
			r = ex. getMessage();
			em.getTransaction().rollback();
			System.out.println("Error");
		}
		return r;
	}

	public String eliminar(Object obj) {
		String resp = null;
		p = (Pais) obj;
		p = em.find(Pais.class, p.getId());
		em.getTransaction().begin();
		try {
			em.remove(p);
			em.getTransaction().commit();
			resp = "1";
			System.out.println("Se eliminó correctamente");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			resp = ex.getMessage();
			System.out.println("Error al eliminar");
		}
		return resp;
	}

	public Object buscar(Object obj) {
		p = (Pais) obj;
		p = em.find(Pais.class, p.getId());
		System.out.println("Se encontró registro: "+p);
		return p;
	}

	public List buscarNombre(Object obj) {
		p = (Pais) obj;
		return em.createQuery("from Pais where nombre like '%"+p.getNombre()+"%'").getResultList();
	}

	public List mostrar() {
		return em.createQuery("from Pais order by id").getResultList();
	}

}
