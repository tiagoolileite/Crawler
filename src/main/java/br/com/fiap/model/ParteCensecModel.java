package br.com.fiap.model;

public class ParteCensecModel {
	
	private Long idParteCensec;
	private String nome;
	private String cpfCnpj;
	private String qualidade;
	
	private ResultadoCensecModel resultado;

	public Long getIdParteCensec() {
		return idParteCensec;
	}

	public void setIdParteCensec(Long idParteCensec) {
		this.idParteCensec = idParteCensec;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public ResultadoCensecModel getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoCensecModel resultado) {
		this.resultado = resultado;
	}
}
