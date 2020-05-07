package br.com.felipesantos.erp.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transactional // P/ O CDI INTERCEPTAR TODAS AS CLASSES E MÉTODOS COM ESSA ANOTAÇÃO
@Priority(Interceptor.Priority.APPLICATION)
public class TransactionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	// MÉTODO INTERCEPTADOR
	@AroundInvoke 
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean criador = false;

		try {
			if (!entityTransaction.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit confirmaria até mesmo operações sem transação)
				entityTransaction.begin();
				entityTransaction.rollback();

				// agora sim inicia a transação
				entityTransaction.begin();
				criador = true;
			}
			// AVISA AO CDI QUE REALMENTE O MÉTODO FOI PROCESSADO
			return context.proceed(); 
		} catch (Exception e) {

			if (entityTransaction != null && criador) {
				entityTransaction.rollback();
			}
			throw e;
		} finally {

			if (entityTransaction != null && entityTransaction.isActive() && criador) {
				entityTransaction.commit();
			}
		}
	}
}
