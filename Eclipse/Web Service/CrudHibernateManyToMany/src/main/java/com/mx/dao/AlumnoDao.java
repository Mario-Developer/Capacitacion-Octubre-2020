package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Alumno;
import com.mx.general.Operaciones;

public class AlumnoDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clases");
	EntityManager em = emf.createEntityManager();
	Alumno a = null;
	
	public List mostrar() {
		return em.createQuery("from Alumno").getResultList();
	}

	public void guardar(Object obj) {
		a = (Alumno) obj;
		em.getTransaction().begin();
		try {
			em.persist(a);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se guardo: "+e.getMessage());
		}
	}

	public void editar(Object obj) {
		a = (Alumno) obj;
		em.getTransaction().begin();
		try {
			em.merge(a);
			em.getTransaction().commit();
			System.out.println("Editado");			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se editó: "+e.getMessage());
		}		
	}

	public void eliminar(Object obj) {
		a = (Alumno) obj;
		a = em.find(Alumno.class, a.getId());
		em.getTransaction().begin();
		try {
			em.remove(a);
			em.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se eliminó: "+e.getMessage());
		}
		
	}

	public Object buscar(Object obj) {
		a = (Alumno) obj;		
		return a = em.find(Alumno.class, a.getId());
	}
	
}
