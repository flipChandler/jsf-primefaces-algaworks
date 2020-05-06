package br.com.felipesantos.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.erp.model.Empresa;

public class SchemaGeneration {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
		System.out.println(lista);

	}
}
