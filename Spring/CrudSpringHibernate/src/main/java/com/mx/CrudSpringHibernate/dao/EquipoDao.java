package com.mx.CrudSpringHibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.CrudSpringHibernate.entidad.Equipo;
import com.mx.CrudSpringHibernate.general.Operaciones;


public class EquipoDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Equipos");
	EntityManager em = emf.createEntityManager();
	Equipo e = null;
	
	@Override
	public List mostrar() {
		return em.createQuery("from Equipo").getResultList();
	}
	
	@Override
	public void guardar(Object obj) {
		e = (Equipo) obj;
		em.getTransaction().begin();
		try {
			em.persist(e);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No guardado: "+e.getMessage());
		}
	}

	@Override
	public void editar(Object obj) {
		e = (Equipo) obj;		
		em.getTransaction().begin();
		try {
			em.merge(e);
			em.getTransaction().commit();
			System.out.println("Editado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No Editado: "+e.getMessage());
		}
		
	}

	@Override
	public void eliminar(Object obj) {
		e = (Equipo) obj;
		e = em.find(Equipo.class, e.getId());
		em.getTransaction().begin();
		try {
			em.remove(e);
			em.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No Eliminado: "+e.getMessage());
		}
		
	}

	@Override
	public Object buscar(Object obj) {
		e = (Equipo) obj;
		return e = em.find(Equipo.class, e.getId());
	}
}
