package br.com.felipesantos.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.felipesantos.erp.model.Empresa;
import br.com.felipesantos.erp.repository.EmpresaRepository;
import br.com.felipesantos.erp.util.Transactional;

public class CadastroEmpresaService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	@Transactional
	public void salvar(Empresa empresa) {
		empresaRepository.guardar(empresa);
	}
	
	@Transactional
	public void excluir (Empresa empresa) {
		empresaRepository.remover(empresa);
	}

}
