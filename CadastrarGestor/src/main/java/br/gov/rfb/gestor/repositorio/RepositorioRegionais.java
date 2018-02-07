package br.gov.rfb.gestor.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.rfb.gestor.modelo.Regional;

public class RepositorioRegionais implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Regional buscarPorId(Long id) {
		return manager.find(Regional.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Regional> regiaoFiscal() {
		return manager.createQuery("from Regional").getResultList();
	}
}
