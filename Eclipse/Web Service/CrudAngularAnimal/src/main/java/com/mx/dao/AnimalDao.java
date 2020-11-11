package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entidades.Animal;
import com.mx.general.Estatus;
import com.mx.general.Operaciones;

public class AnimalDao implements Operaciones{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Animales");
	EntityManager em = emf.createEntityManager();
	Animal a = null;
	String r = null;
	
	public List mostrar() {
		List<Animal> lista = em.createQuery("from Animal order by id").getResultList();
		return lista;
	}
	
	public String guardar(Object obj) {
		a = (Animal) obj;
		em.getTransaction().begin();
		try {
			em.persist(a);
			em.getTransaction().commit();
			r = "1";
			System.out.println("Animal guardado");
			em.close();
		} catch (Exception e2) {
			r= e2.getMessage();
			em.getTransaction().rollback();
			System.out.println("Animal no guardado");
		}
		return r;
	}
	
	public String editar(Object Obj) {
		a = (Animal) Obj;
		Animal a2 = new Animal();
		a2 = em.find(Animal.class, a.getId());
		em.getTransaction().begin();
		try {
			a2.setNombre(a.getNombre());
			a2.setTipo(a.getTipo());
			a2.setEdad(a.getEdad());
			em.getTransaction().commit();
			r = "1";
			System.out.println("Animal editado");
		} catch (Exception e) {
			r = e.getMessage();
			em.getTransaction().rollback();
			System.out.println("Animal no editado");
		}
		return r;
	}
	public String eliminar(Object Obj) {
		a = (Animal) Obj;
		a = em.find(Animal.class, a.getId());
		em.getTransaction().begin();
		try {
			em.remove(a);
			em.getTransaction().commit();
			System.out.println("Animal eliminado");
			r = "1";
		} catch (Exception e) {
			r = e.getMessage();
			em.getTransaction().rollback();
			System.out.println("Animal no eliminado");
		}
		return r;
	}
	public Object buscar(Object Obj) {
		a = (Animal) Obj;
		a = em.find(Animal.class, a.getId());
		System.out.println("Se encontró Animal: "+a);
		return a;
	}

	
}
