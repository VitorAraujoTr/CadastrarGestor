package br.gov.rfb.gestor.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Regional implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String regiaoFiscal;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "regiao_fiscal", nullable = false, length = 100)
	public String getRegiaoFiscal() {
		return regiaoFiscal;
	}

	public void setRegiaoFiscal(String regiaoFiscal) {
		this.regiaoFiscal = regiaoFiscal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Regional other = (Regional) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
