package br.gov.rfb.gestor.usuario.modelo;

public class Usuario {
	private long cpf;
	private String nome;
	private String uf;
	
	public Usuario(long cpf, String nome, String uf) {
		this.cpf = cpf;
		this.nome = nome;
		this.uf = uf;
	}
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
