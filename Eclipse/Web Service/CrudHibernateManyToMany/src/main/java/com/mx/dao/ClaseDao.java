package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Alumno;
import com.mx.entidad.Clase;
import com.mx.entidad.Profesor;
import com.mx.general.Operaciones;

public class ClaseDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clases");
	EntityManager em = emf.createEntityManager();
	Alumno a = null;
	Profesor p = null;
	Clase c = null;
	
	public List mostrar() {		
		return em.createQuery("from Clase").getResultList();
	}

	public void guardar(Object obj) {		
		c = (Clase) obj;
		a = em.find(Alumno.class, c.getAlumno().getId());
		p = em.find(Profesor.class, c.getProfesor().getId());
		em.getTransaction().begin();
		try {
			em.persist(c);
			c.setAlumno(a);
			c.setProfesor(p);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No guadado");
		}
	}

	public void editar(Object obj) {
		
	}

	public void eliminar(Object obj) {
		/*c = (Clase) obj;
		c = em.find(Clase.class, c.getId());
		em.getTransaction().begin();
		try {
			em.remove(c);
			em.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No eliminado: "+e.getMessage());
		}*/
	}

	public Object buscar(Object obj) {
		c = (Clase) obj;
		return null;
	}

}
