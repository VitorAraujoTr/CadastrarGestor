package br.gov.rfb.gestor.repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.gov.rfb.gestor.modelo.Gestor;

public class RepositorioGestores implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Gestor guardar(Gestor gestor) {
		return manager.merge(gestor);
	}
	
	public Gestor porCpf(String cpf) {
		try {
			return manager.createQuery("from Gestor where upper(cpf) = :cpf", Gestor.class)
					.setParameter("cpf", cpf)
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
}
