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

	 public static void merge(){
		 //Query Libro by ID
		 //Open Transaction
		 manager.getTransaction().begin();
		 //Set Libro
		 Libros libro = new Libros();
		 libro.setId(10);
		 libro.setTitulo("Libro de prueba");
		 libro.setAutor("Nuevo autor");
		 //Update Libro
		 manager.merge(libro);
		 //Commit changes
		 manager.getTransaction().commit();
		 }
	 
	 public static void remove(){
		 //Query Libro by ID
		 Libros libro = manager.find(Libros.class, 10);
		 //Open transaction
		 manager.getTransaction().begin();
		 //Delete Libro
		 manager.remove(libro);
		 //Commit transaction
		 manager.getTransaction().commit();
		 }
	 
	 public static void verTodos() {
		 System.out.println("Mostrando todos los datos:");
		 Query consulta = manager.createQuery("Select l "
		 + "from Libros l");
		 List resultados = consulta.getResultList();
		 for (Object resultado : resultados) {
			 Libros libro = (Libros) resultado;
			 System.out.println(libro.getId() + ": "
			 + libro.getTitulo() + ", de "
			 + libro.getAutor());
		 }
	 }
	 
	 public static void verUnTitulo() {
		 System.out.println("Mostrando todos los datos:");
		 Libros libro = manager
		 .createNamedQuery( "Libros.findByTitulo", Libros.class )
		 .setParameter( "titulo", "Macbeth" )
		 .getSingleResult();
		 System.out.println(libro.getId() + ": "
		 + libro.getTitulo() + ", de "
		 + libro.getAutor());
	 }


	
	public static void main(String[] args) {
		tearUp();
		//persist(); // crea los campos
		//merge(); // actualiza los campos
		//remove(); // borra una fila
		//verTodos(); // muestra todas los registros de la tabla
		//find(); // busca un registro específico (por ID)
		verUnTitulo(); // busca un registro filtrando por titulo
		tearDown();
	}
}