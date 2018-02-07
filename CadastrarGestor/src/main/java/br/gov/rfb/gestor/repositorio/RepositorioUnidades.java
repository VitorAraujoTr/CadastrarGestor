package br.gov.rfb.gestor.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.rfb.gestor.modelo.Unidade;

public class RepositorioUnidades implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Unidade buscarPorId(Long id){
		return manager.find(Unidade.class, id);
	}
	
	public List<Unidade> buscarFederativa(){
		return manager.createQuery("from Unidade where unidadePai is null", Unidade.class).getResultList();
	}
	
	public List<Unidade> buscarAdministrativa(Unidade unidadePai){
		return manager.createQuery("from Unidade where unidadePai = :raiz",
				Unidade.class)
				.setParameter("raiz", unidadePai)
				.getResultList();
	}
}
