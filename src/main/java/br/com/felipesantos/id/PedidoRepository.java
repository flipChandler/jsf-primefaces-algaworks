package br.com.felipesantos.id;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class PedidoRepository {
	
	@Inject
	private EntityManager manager;

	public BigDecimal totalPedidosMesAtual () {
		return new BigDecimal("100");
	}
}
