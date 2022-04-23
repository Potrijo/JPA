package com.marc.jpa1;

import javax.persistence.EntityManager;

public class Jpa1 {
	public static void main(String[] args) {
		EntityManager manager = EntityManagerUtil.getEntityManager();
		manager.close();
	}
}


