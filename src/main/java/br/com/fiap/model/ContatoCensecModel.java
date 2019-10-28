package br.com.fiap.model;

public class ContatoCensecModel {
	private String telefone;
	private String tipo;
	private String ramal;
	private String contato;
	private String status;
	
	private ResultadoCensecModel resultado;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ResultadoCensecModel getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCensecModel resultado) {
		this.resultado = resultado;
	}
}
