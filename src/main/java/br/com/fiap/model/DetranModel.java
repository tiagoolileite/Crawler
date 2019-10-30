package br.com.fiap.model;

public class DetranModel {
	private long idDetran;
	private String renach;
	private String categoria;
	private String emissao;
	private String dtNascimento;
	private String nomeCondutor;
	private String nomePai;
	private String nomeMae;
	private String registro;
	private String tipografico;
	private String identidade;
	private String cpf;
	private long idPf;
	
	
	
	public DetranModel() {
	}
	public DetranModel(long idDetran, String renach, String categoria, String emissao, String dtNascimento,
			String nomeCondutor, String nomePai, String nomeMae, String registro, String tipografico, String identidade,
			String cpf, long idPf) {
		super();
		this.idDetran = idDetran;
		this.renach = renach;
		this.categoria = categoria;
		this.emissao = emissao;
		this.dtNascimento = dtNascimento;
		this.nomeCondutor = nomeCondutor;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.registro = registro;
		this.tipografico = tipografico;
		this.identidade = identidade;
		this.cpf = cpf;
		this.idPf = idPf;
	}
	public long getIdDetran() {
		return idDetran;
	}
	public void setIdDetran(long idDetran) {
		this.idDetran = idDetran;
	}
	public String getRenach() {
		return renach;
	}
	public void setRenach(String renach) {
		this.renach = renach;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEmissao() {
		return emissao;
	}
	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getNomeCondutor() {
		return nomeCondutor;
	}
	public void setNomeCondutor(String nomeCondutor) {
		this.nomeCondutor = nomeCondutor;
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
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getTipografico() {
		return tipografico;
	}
	public void setTipografico(String tipografico) {
		this.tipografico = tipografico;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public long getIdPf() {
		return idPf;
	}
	public void setIdPf(long idPf) {
		this.idPf = idPf;
	}
}
