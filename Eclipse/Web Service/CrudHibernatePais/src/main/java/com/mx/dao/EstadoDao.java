package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Estado;
import com.mx.entidades.Pais;
import com.mx.generales.Operaciones;

public class EstadoDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Regiones");
	EntityManager em = emf.createEntityManager();
	Estado e = null;
	Pais p = null;
	
	public String guardar(Object obj) {
		e = (Estado)obj;
		p = em.find(Pais.class, e.getPais().getId());
		em.getTransaction().begin();
		String r = null;
		try {
			em.persist(e);
			e.setPais(p);
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
		e = (Estado) obj;
		p = em.find(Pais.class, e.getPais().getId());		
		Estado ebd = em.find(Estado.class, e.getId());
		String r = null;
		em.getTransaction().begin();
		try {
			ebd.setNombre(e.getNombre());
			ebd.setHabitantes(e.getHabitantes());
			ebd.setPais(p);			
			em.getTransaction().commit();
			System.out.println("Se editó el estado-> "+e);
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
		e = (Estado) obj;
		e = em.find(Estado.class, e.getId());
		em.getTransaction().begin();
		try {
			em.remove(e);
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
		e = (Estado) obj;
		e = em.find(Estado.class, e.getId());
		System.out.println("Se encontró registro: "+e);
		return e;
	}

	public List buscarNombre(Object obj) {
		e = (Estado) obj;
		return em.createQuery("from Estado where nombre like '%"+e.getNombre()+"%'").getResultList();
	}

	public List mostrar() {
		return em.createQuery("from Estado order by id").getResultList();
	}
	
}
