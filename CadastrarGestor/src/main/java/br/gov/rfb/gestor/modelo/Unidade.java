package br.gov.rfb.gestor.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Unidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String descricao;
	private Unidade unidadePai;
	private List<Unidade> subUnidades = new ArrayList<>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne
	@JoinColumn(name = "unidade_pai_id")
	public Unidade getUnidadePai() {
		return unidadePai;
	}

	public void setUnidadePai(Unidade unidadePai) {
		this.unidadePai = unidadePai;
	}
	
	@OneToMany(mappedBy="unidadePai", cascade = CascadeType.ALL)
	public List<Unidade> getSubUnidades() {
		return subUnidades;
	}

	public void setSubUnidades(List<Unidade> subUnidades) {
		this.subUnidades = subUnidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
