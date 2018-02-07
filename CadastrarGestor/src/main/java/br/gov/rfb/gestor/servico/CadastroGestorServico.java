package br.gov.rfb.gestor.servico;

import java.io.Serializable;

import javax.inject.Inject;

import br.gov.rfb.gestor.modelo.Gestor;
import br.gov.rfb.gestor.repositorio.RepositorioGestores;
import br.gov.rfb.gestor.util.jpa.Transacional;

public class CadastroGestorServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RepositorioGestores repositorioGestores;
	
	@Transacional
	public Gestor salvar(Gestor gestor) {
		Gestor gestorExistente = repositorioGestores.porCpf(gestor.getCpf());
		
		if(gestorExistente != null) {
			throw new NegocioException("CPF já cadastrado!!!");
		}
		return repositorioGestores.guardar(gestor);
	}
	
	
}
