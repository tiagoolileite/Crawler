package br.com.fiap.model;

import java.util.List;

public class ResultadoCensecModel {
	
	private Long idCensec;
	private String nomeEmpresa;
	private String cpfCnpj;
	private String identidade;
	private String cartorio;
	private String tipoAto;
	private String livro;
	private String folha;
	private String dtAto;
	private String carga;
	private String atoCarga;
	private String dtAtoCarga;
	private String livroCarga;
	private String complementoLivroCarga;
	private String folhaCarga;
	private String complementoFolhaCarga;
	
	private List<ParteCensecModel> partes;
	private List<ContatoCensecModel> contatos;
	
	private PFJsonModel pf;
	private PJJsonModel pj;
	
	public ResultadoCensecModel() {

	}
	public ResultadoCensecModel(Long idCensec, String nomeEmpresa, String cpfCnpj, String identidade, String cartorio,
			String tipoAto, String livro, String folha, String dtAto, String carga, String atoCarga, String dtAtoCarga,
			String livroCarga, String complementoLivroCarga, String folhaCarga, String complementoFolhaCarga,
			PFJsonModel pf) {
		super();
		this.idCensec = idCensec;
		this.nomeEmpresa = nomeEmpresa;
		this.cpfCnpj = cpfCnpj;
		this.identidade = identidade;
		this.cartorio = cartorio;
		this.tipoAto = tipoAto;
		this.livro = livro;
		this.folha = folha;
		this.dtAto = dtAto;
		this.carga = carga;
		this.atoCarga = atoCarga;
		this.dtAtoCarga = dtAtoCarga;
		this.livroCarga = livroCarga;
		this.complementoLivroCarga = complementoLivroCarga;
		this.folhaCarga = folhaCarga;
		this.complementoFolhaCarga = complementoFolhaCarga;
		this.pf = pf;
	}
	
	public Long getIdCensec() {
		return idCensec;
	}
	public void setIdCensec(Long idCensec) {
		this.idCensec = idCensec;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getCartorio() {
		return cartorio;
	}
	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}
	public String getTipoAto() {
		return tipoAto;
	}
	public void setTipoAto(String tipoAto) {
		this.tipoAto = tipoAto;
	}
	public String getLivro() {
		return livro;
	}
	public void setLivro(String livro) {
		this.livro = livro;
	}
	public String getFolha() {
		return folha;
	}
	public void setFolha(String folha) {
		this.folha = folha;
	}
	public String getDtAto() {
		return dtAto;
	}
	public void setDtAto(String dtAto) {
		this.dtAto = dtAto;
	}
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	public String getAtoCarga() {
		return atoCarga;
	}
	public void setAtoCarga(String atoCarga) {
		this.atoCarga = atoCarga;
	}
	public String getDtAtoCarga() {
		return dtAtoCarga;
	}
	public void setDtAtoCarga(String dtAtoCarga) {
		this.dtAtoCarga = dtAtoCarga;
	}
	public String getLivroCarga() {
		return livroCarga;
	}
	public void setLivroCarga(String livroCarga) {
		this.livroCarga = livroCarga;
	}

	public String getFolhaCarga() {
		return folhaCarga;
	}
	public void setFolhaCarga(String folhaCarga) {
		this.folhaCarga = folhaCarga;
	}
	public String getComplementoFolhaCarga() {
		return complementoFolhaCarga;
	}
	public void setComplementoFolhaCarga(String complementoFolhaCarga) {
		this.complementoFolhaCarga = complementoFolhaCarga;
	}
	public String getComplementoLivroCarga() {
		return complementoLivroCarga;
	}
	public void setComplementoLivroCarga(String complementoLivroCarga) {
		this.complementoLivroCarga = complementoLivroCarga;
	}
	public List<ParteCensecModel> getPartes() {
		return partes;
	}
	public void setPartes(List<ParteCensecModel> partes) {
		this.partes = partes;
	}
	public List<ContatoCensecModel> getContatos() {
		return contatos;
	}
	public void setContatos(List<ContatoCensecModel> contatos) {
		this.contatos = contatos;
	}
	public PFJsonModel getPf() {
		return pf;
	}
	public void setPf(PFJsonModel pf) {
		this.pf = pf;
	}
	public PJJsonModel getPj() {
		return pj;
	}
	public void setPj(PJJsonModel pj) {
		this.pj = pj;
	}
}
