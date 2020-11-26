package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Novia;
import com.mx.general.Operaciones;

public class NoviaDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Relaciones");
	EntityManager em = emf.createEntityManager();
	Novia novia = null;

	public void guardar(Object obj) {
		novia = (Novia) obj;
		em.getTransaction().begin();
		try {
			em.persist(novia);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No guardado");
		}		
	}

	public void editar(Object obj) {
		novia = (Novia) obj;
		em.getTransaction().begin();
		try {
			em.merge(novia); //Actualiza todo el objeto
			em.getTransaction().commit();
			System.out.println("Editado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No Editado");
		}				
	}

	public void eliminar(Object obj) {
		novia = (Novia) obj;
		novia = em.find(Novia.class, novia.getId());
		em.getTransaction().begin();
		try {
			em.remove(novia);
			em.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No eliminado "+e.getMessage());
		}
	}

	public List mostrar() {		
		return em.createQuery("from Novia order by id").getResultList();
	}

	public Object buscar(Object obj) {
		novia = (Novia) obj;
		novia = em.find(Novia.class, novia.getId());
		return novia;
	}

}
