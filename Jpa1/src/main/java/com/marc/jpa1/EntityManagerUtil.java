package com.marc.jpa1;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 *
 * @author Fran
 */
public class EntityManagerUtil {
 private static final EntityManager manager;

	 static {
	 try {
	 manager = Persistence.
	 createEntityManagerFactory("Jpa1").
	 createEntityManager();
	 } catch (Throwable ex) {
	 // Log the exception.
	 System.err.println("Initial EntityManager creation failed."
	 + ex);
	 throw new ExceptionInInitializerError(ex);
	 }
	 }

	 public static EntityManager getEntityManager() {
	 return manager;
	 }

	 public static void main(String[] args) {
	 System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
	 }
}
