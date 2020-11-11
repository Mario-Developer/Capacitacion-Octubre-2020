package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Tanque;
import com.mx.generales.Operaciones;

public class TanqueDao implements Operaciones{
	Tanque t = null;
	Tanque tn = null;

	public String guardar(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		String resp;
		t = (Tanque) obj;
		em.getTransaction().begin();
		
		try {
			em.persist(t);
			em.getTransaction().commit();
			resp = "1";
			System.out.println("Se guardó corrrectamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resp = "0";
			System.out.println("Operación Incorrecta");
		}
		return resp;
	}

	public String editar(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		String resp = null;
		tn = (Tanque) obj;
		t = em.find(Tanque.class, tn.getId());
		em.getTransaction().begin();
		try {
			t.setNombre(tn.getNombre());
			t.setPais(tn.getPais());
			t.setDano(tn.getDano());
			t.setHp(tn.getHp());
			em.getTransaction().commit();
			resp = "1";
			System.out.println("Se edito correctamente");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resp = "0";
			System.out.println("Operación Incorrecta");
		}
		return resp;
	}

	public String eliminar(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		String resp= null;
		t = (Tanque) obj;
		t = em.find(Tanque.class, t.getId());
		em.getTransaction().begin();
		try {
			em.remove(t);
			em.getTransaction().commit();
			resp = "1";
			System.out.println("Se eliminó tanque");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resp = "0";
			System.out.println("Error al eliminar");
		}
		return resp;
	}

	public Object buscar(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		t = (Tanque) obj;
		t = em.find(Tanque.class, t.getId());
		System.out.println("Se encontro registro: "+t);
		return t;
	}
	
	public List buscarNombre(Object obj) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		t = (Tanque) obj;
		System.out.println("t = "+t);
		List <Tanque> lista = em.createQuery("from Tanque where nombre like '%"+t.getNombre()+"%'").getResultList();
		System.out.println("Datos-> "+lista);
		return lista;
	}

	public List mostrar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		EntityManager em = emf.createEntityManager();
		
		List<Tanque> lista = em.createQuery("from Tanque").getResultList();
		System.out.println("Datos-> "+lista);
		return lista;
	}
}
