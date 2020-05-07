package br.com.felipesantos.erp.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//INDICA QUE ESSA INSTANCIA DEVE SOBREVIVER DURANTE TODO O CICLO DE VIDA DA APP
@ApplicationScoped
public class EntityManagerProducer {
	
	private EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
	}
	
	
	@Produces // CDI CRIARÁ ESSA INSTANCIA TD VEZ QUE UM CLASSE SOLICITAR UM ENTITYMANAGER
	@RequestScoped // CADA REQUISIÇÃO, SERÁ UM ENTITYMANAGER NOVO
	public EntityManager createEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close(); // ACABOU A REQUISIÇÃO, ENTITMANAGER SERÁ ENCERRADO
	}

}
