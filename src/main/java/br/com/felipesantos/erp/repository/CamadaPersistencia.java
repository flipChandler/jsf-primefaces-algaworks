package br.com.felipesantos.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.felipesantos.erp.model.Empresa;
import br.com.felipesantos.erp.model.RamoAtividade;
import br.com.felipesantos.erp.model.TipoEmpresa;

public class CamadaPersistencia {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		RamoAtividadeRepository ramoAtividadeRepository = new RamoAtividadeRepository(em);
		EmpresaRepository empresaRepository = new EmpresaRepository(em);
		
		List<RamoAtividade> listaRamoAtividades = ramoAtividadeRepository.pesquisar("");
		List<Empresa> listaEmpresas = empresaRepository.pesquisar("");
		System.out.println(listaEmpresas);
		
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("John Doe");
		empresa.setCnpj("42.952.300/0001-45");
		empresa.setRazaoSocial("John Doe MEI");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaRamoAtividades.get(0));
		
		empresaRepository.guardar(empresa);
		
		em.getTransaction().commit();
		
		// CHECK SE A INSERÇÃO FUNCIONOU
		List<Empresa> listaEmpresas2 = empresaRepository.pesquisar("");
		System.out.println(listaEmpresas2);
		
		em.close();
		emf.close();
	}
	
}
