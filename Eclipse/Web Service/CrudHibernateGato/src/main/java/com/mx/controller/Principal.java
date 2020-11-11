package com.mx.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidad.Gato;

public class Principal {
	public static void main(String[] args) {
		buscarNombre();
	}
	
	public static void eliminar() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		Gato g = new Gato(1);
		g = em.find(Gato.class, g.getId());
		em.getTransaction().begin();
		try {
			em.remove(g);
			em.getTransaction().commit();
			System.out.println("Se eliminó gato");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error al eliminar");
		}
	}
	
	public static void buscarId() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		Gato g = new Gato(2);
		g = em.find(Gato.class, g.getId());
		System.out.println("Se encontró el gato: "+g);
	}
	
	public static void buscarNombre() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		Gato g = new Gato(0, "FELICIA", null, 0);
		List<Gato> lista = em.createQuery("from Gatitos where nombre = '"+g.getNombre()+"'").getResultList();
		System.out.println("Datos->"+lista.get(0));
	}
	
	public static void editar() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		Gato g = new Gato(2);
		g = em.find(Gato.class, g.getId());
		em.getTransaction().begin();
		try {
			g.setGenero("FEMENINO");
			g.setNombre("FELICIA");
			em.getTransaction().commit();
			System.out.println("Se editó gato");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error al editar");
		}
	}
	
	public static void mostrar() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
		
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		List<Gato> lista = em.createQuery("from Gato").getResultList();
		System.out.println("datos->"+lista);
	}
	
	public static void guardar() {
		//Carga los objetos mapeados en el archivo persistences.xlm
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
				
		//carga operaciones como guardar, editar, contar, buscar, mostrar, etc
		EntityManager em = emf.createEntityManager();
		
		Gato g = new Gato(1, "DON GATO", "MASCULINO", 14);
		em.getTransaction().begin();
		
		try {
			em.persist(g);
			em.getTransaction().commit();
			System.out.println("Se insertó Gato");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Error al insertar");
		}
	}
}
