package br.com.example.demo;

public class Endereco {

	private String bairro;
	private String cidade;
	private String logradouro;
	private String cep;
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [bairro=" + bairro + ", cidade=" + cidade + ", logradouro=" + logradouro + ", cep=" + cep
				+ ", estado=" + estado + "]";
	}
	
}
