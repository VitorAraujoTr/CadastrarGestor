package br.gov.rfb.gestor.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.gov.rfb.gestor.modelo.enumerador.PermissaoGestor;
import br.gov.rfb.gestor.modelo.enumerador.EnumeradorUF;

@Entity
public class Gestor implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private EnumeradorUF uf;
	private PermissaoGestor permissao;
	private Nacional nacional = new Nacional();
	private Regional regional = new Regional();
	private Local local = new Local();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length = 14, nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length = 14, nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 2, nullable = false)
	public EnumeradorUF getUf() {
		return uf;
	}

	public void setUf(EnumeradorUF uf) {
		this.uf = uf;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public PermissaoGestor getPermissao() {
		return permissao;
	}

	public void setPermissao(PermissaoGestor permissao) {
		this.permissao = permissao;
	}
	@OneToOne
	@JoinColumn(name = "nacional_id", nullable = true)
	public Nacional getNacional() {
		return nacional;
	}

	public void setNacional(Nacional nacional) {
		this.nacional = nacional;
	}

	@OneToOne
	@JoinColumn(name = "regional_id", nullable = true)
	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	@OneToOne
	@JoinColumn(name = "local_id", nullable = true)
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
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
		Gestor other = (Gestor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
