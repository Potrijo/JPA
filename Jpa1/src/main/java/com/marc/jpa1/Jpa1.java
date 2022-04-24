package com.marc.jpa1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Jpa1 {
	private static EntityManager manager;
	
	public static void tearUp() {
		// Crear el EntityManager
		manager = EntityManagerUtil.getEntityManager();
	}
	
	public static void tearDown() {
		// Cerrar el EntityManager
		manager.close();
	}
	
	public static void find() {
		// Query  Libro by ID
		Libros libro = manager.find(Libros.class, 1);
		// Print libro
		System.out.println("Título del libro ==> " + libro.getTitulo());
	}
	
	public static void persist() {
		 //Open Transaction
		 manager.getTransaction().begin();
		 Libros libro = new Libros();
		 libro.setId(10);
		 libro.setTitulo("Pakito el chocolatero");
		 libro.setAutor("Marc");
		 //Persist Libro
		 manager.persist(libro);
		 //Commit Transaction
		 manager.getTransaction().commit();
	 }

	
	public static void main(String[] args) {
		tearUp();
		persist();
		find();
		tearDown();
	}
}