package br.gov.rfb.gestor.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.gov.rfb.gestor.jsf.FacesUtil;
import br.gov.rfb.gestor.modelo.Gestor;
import br.gov.rfb.gestor.modelo.Regional;
import br.gov.rfb.gestor.modelo.Unidade;
import br.gov.rfb.gestor.modelo.enumerador.EnumeradorUF;
import br.gov.rfb.gestor.repositorio.RepositorioRegionais;
import br.gov.rfb.gestor.repositorio.RepositorioUnidades;
import br.gov.rfb.gestor.servico.CadastroGestorServico;

@Named
@ViewScoped
public class CadastroGestorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RepositorioRegionais repositorioRegionais;

	@Inject
	private RepositorioUnidades repositorioUnidades;
	
	@Inject
	private CadastroGestorServico cadastroGestorServico;

	private Gestor gestor;

	private Regional regional;

	private List<Regional> regionais;

	private Unidade unidadePai;

	private List<Unidade> unidadesFederativas;

	private List<Unidade> unidadesAdministrativas;

	public CadastroGestorBean() {
		gestor = new Gestor();
	}

	public void inicializar() {
		System.out.println("Inicializando...");

		if (FacesUtil.isNotPostBack()) {
			regionais = repositorioRegionais.regiaoFiscal();
			unidadesFederativas = repositorioUnidades.buscarFederativa();
		}
	}

	public void salvar() {
		gestor = cadastroGestorServico.salvar(this.gestor);
		
		FacesUtil.addInfoMessage("Gestor salvo com sucesso!!!");
		FacesUtil.addInfoMessage("Aguarde um supervisor aprovar seu cadastro, para que tenha acesso ao sistema.");
	}

	public void carregarUnidade() {
		unidadesAdministrativas = repositorioUnidades.buscarAdministrativa(unidadePai);
	}

	public Gestor getGestor() {
		return gestor;
	}

	public Regional getRegional() {
		return regional;
	}

	public List<Regional> getRegionais() {
		return regionais;
	}

	public Unidade getUnidadePai() {
		return unidadePai;
	}
	
	public void setUnidadePai(Unidade unidadePai) {
		this.unidadePai = unidadePai;
	}

	public List<Unidade> getUnidadesFederativas() {
		return unidadesFederativas;
	}

	public List<Unidade> getUnidadesAdministrativas() {
		return unidadesAdministrativas;
	}

	public EnumeradorUF[] getUf() {
		return EnumeradorUF.values();
	}
}