package br.com.fiap.model;

public class SielModel {
	private long idSiel;
	private String nome;
	private String titulo;
	private String dtNascimento;
	private String zona;
	private String endereco;
	private String municipio;
	private String uf;
	private String dtDomicilio;
	private String nomePai;
	private String nomeMae;
	private String naturalidade;
	private String codValidacao;
	private long idPf;
	
	public SielModel() {
	}
	public SielModel(long idSiel, String nome, String titulo, String dtNascimento, String zona, String endereco,
			String municipio, String uf, String dtDomicilio, String nomePai, String nomeMae, String naturalidade,
			String codValidacao, long idPf) {
		super();
		this.idSiel = idSiel;
		this.nome = nome;
		this.titulo = titulo;
		this.dtNascimento = dtNascimento;
		this.zona = zona;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.dtDomicilio = dtDomicilio;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.naturalidade = naturalidade;
		this.codValidacao = codValidacao;
		this.idPf = idPf;
	}
	public long getIdSiel() {
		return idSiel;
	}
	public void setIdSiel(long idSiel) {
		this.idSiel = idSiel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDtDomicilio() {
		return dtDomicilio;
	}
	public void setDtDomicilio(String dtDomicilio) {
		this.dtDomicilio = dtDomicilio;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	public long getIdPf() {
		return idPf;
	}
	public void setIdPf(long idPf) {
		this.idPf = idPf;
	}
	
	
}
