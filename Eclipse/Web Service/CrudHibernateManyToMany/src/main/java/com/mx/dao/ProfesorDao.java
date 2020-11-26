package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Profesor;
import com.mx.general.Operaciones;

public class ProfesorDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clases");
	EntityManager em = emf.createEntityManager();
	Profesor p = null;
	
	public List mostrar() {	
		return em.createQuery("from Profesor").getResultList();
	}

	public void guardar(Object obj) {
		p = (Profesor) obj;
		em.getTransaction().begin();
		try {
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se guardo: "+e.getMessage());
		}
	}

	public void editar(Object obj) {
		p = (Profesor) obj;
		em.getTransaction().begin();
		try {
			em.merge(p);
			em.getTransaction().commit();
			System.out.println("Editado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se edito: "+e.getMessage());
		}
	}

	public void eliminar(Object obj) {
		p = (Profesor) obj;
		p = em.find(Profesor.class, p.getId());
		em.getTransaction().begin();
		try {
			em.remove(p);
			em.getTransaction().begin();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se elimino: "+e.getMessage());
		}
	}

	public Object buscar(Object obj) {
		p = (Profesor) obj;
		return p = em.find(Profesor.class, p.getId());
	}

}
