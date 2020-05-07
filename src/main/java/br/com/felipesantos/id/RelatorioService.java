package br.com.felipesantos.id;

import java.math.BigDecimal;

import javax.inject.Inject;

public class RelatorioService {
	
	@Inject
	private PedidoRepository pedidoRepository;
	
	
	
	public RelatorioService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public RelatorioService() {
		
	}


	public BigDecimal totalPedidosMesAtual() {
		return pedidoRepository.totalPedidosMesAtual();
	}
	
	public void setPedidoRepository(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

}
