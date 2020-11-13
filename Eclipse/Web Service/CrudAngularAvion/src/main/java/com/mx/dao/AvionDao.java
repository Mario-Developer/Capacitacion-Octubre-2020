package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Avion;
import com.mx.general.Operaciones;

public class AvionDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aviones");
	EntityManager em = emf.createEntityManager();
	Avion a = null;
	String r = null;

	public List mostar() {
		List<Avion> lista = em.createQuery("from Avion").getResultList();
		return lista;
	}
	
	public String guardar(Object obj) {
		a = (Avion) obj;
		em.getTransaction().begin();
		try {
			em.persist(a);
			em.getTransaction().commit();
			r = "1";
			System.out.println("Objeto guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			r = e.getMessage();			
			System.out.println("Objeto no guardado");
		}
		return r;
	}

	public String editar(Object obj) {
		a = (Avion) obj;
		Avion a2 = new Avion();
		a2 = em.find(Avion.class, a.getId());
		em.getTransaction().begin();
		try {
			a2.setMarca(a.getMarca());
			a2.setModelo(a.getModelo());
			a2.setPrecio(a.getPrecio());
			em.getTransaction().commit();
			r = "1";
			System.out.println("Objeto editado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			r = e.getMessage();
			System.out.println("Objeto no guardado");
		}
		return r;
	}

	public String eliminar(Object obj) {
		a = (Avion) obj;
		a = em.find(Avion.class, a.getId());
		em.getTransaction().begin();
		try {
			em.remove(a);
			em.getTransaction().commit();
			r = "1";
			System.out.println("Objeto eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			r = e.getMessage();
			System.out.println("Objecto no eliminado");
		}
		return r;
	}

	public Object buscar(Object obj) {
		a = (Avion) obj;
		a = em.find(Avion.class, a.getId());
		return a;
	}

}
