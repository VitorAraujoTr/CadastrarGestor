package br.gov.rfb.gestor.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.gov.rfb.gestor.modelo.Gestor;

@Named
@ViewScoped
public class PesquisaGestorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Gestor> gestores = new ArrayList<>();

	private Gestor gestorSelecionado;

	public String getChamaAqui() {
		System.out.println("Passou pelo método");
		return "Vamos lá";
	}

	public PesquisaGestorBean() {
		System.out.println("Passou por aqui");
	}

	public void excluirGestor() {
		gestores.remove(gestorSelecionado);
	}

	public List<Gestor> getGestores() {
		return gestores;
	}

	public Gestor getGestorSelecionado() {
		return gestorSelecionado;
	}

	public void setGestorSelecionado(Gestor gestorSelecionado) {
		this.gestorSelecionado = gestorSelecionado;
	}
}
