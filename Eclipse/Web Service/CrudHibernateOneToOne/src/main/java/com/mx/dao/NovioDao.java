package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Novia;
import com.mx.entidad.Novio;
import com.mx.general.Operaciones;

public class NovioDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Relaciones");
	EntityManager em = emf.createEntityManager();
	Novio novio = null;
	Novia novia = null;
	
	public void guardar(Object obj) {
		novio = (Novio) obj;
		novia = em.find(Novia.class, novio.getNovia().getId());
		em.getTransaction().begin();		
		try {
			em.persist(novio);
			novio.setNovia(novia);
			novia.setNovio(novio);
			em.getTransaction().commit();
			System.out.println("Guardado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No Guardado");
		}
	}

	public void editar(Object obj) {
		System.out.println("Entró a Dao");
		Novio gokuE = (Novio) obj;
		Novio gokuB = em.find(Novio.class, novio.getId());
		
		Novia hinata = em.find(Novia.class, gokuB.getNovia().getId());
		Novia milk = em.find(Novia.class, gokuE.getNovia().getId());
		
		Novio naruto = em.find(Novio.class, milk.getNovio().getId());
		em.getTransaction().begin();
		
		try {
			//Romper la relación
			hinata.setNovio(null);
			naruto.setNovia(null);
			
			gokuB.setNombre(gokuE.getNombre());
			gokuB.setApp(gokuE.getApp());
			gokuB.setApm(gokuE.getApm());
			gokuB.setProfesion(gokuE.getProfesion());
			
			gokuB.setNovia(milk);
			milk.setNovio(gokuB);
			
			em.getTransaction().commit();
			System.out.println("Se actualizó la relación");
			System.out.println("Novio: "+gokuB);
			System.out.println("Novia: "+milk);
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No se guardo: "+e.getMessage());
		}
	}

	public void eliminar(Object obj) {
		novio = (Novio) obj;
		novio = em.find(Novio.class, novio.getId());
		novia = em.find(Novia.class, novio.getNovia().getId());
		em.getTransaction().begin();
		try {
			novia.setNovio(null);
			em.remove(novio);
			em.getTransaction().commit();
			System.out.println("Eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("No Eliminado");
		}
	}

	public List mostrar() {		
		return em.createQuery("from Novio").getResultList();
	}

	public Object buscar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
