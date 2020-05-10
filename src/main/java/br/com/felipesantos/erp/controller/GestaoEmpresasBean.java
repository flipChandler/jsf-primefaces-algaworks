package br.com.felipesantos.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.felipesantos.erp.model.Empresa;
import br.com.felipesantos.erp.model.TipoEmpresa;

@Named
@ViewScoped // UTILIZAREMOS ESSE 
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public void salvar() {
		System.out.println("Razão social: " + empresa.getRazaoSocial()
				+ " - Nome fantasia: " + empresa.getNomeFantasia()
				+ " - Tipo: " + empresa.getTipo());
	}
	
	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
	
	
}
