package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ARPENSP")
@SequenceGenerator(name = "REGISTRO_ARPENSP_SEQ", sequenceName = "REGISTRO_ARPENSP_SEQ", initialValue = 1, allocationSize = 1)
public class RegistroArpenspModel {
	
	private long id_registro;
	private String cartorioDeRegistro;
	private String nrCns;
	private String uf;
	private String nomeConjuge1;
	private String nomeConjuge2;
	private String novoNomeConjuge2;
	private String dtCasamento;
	private String matricula;
	private String dtEntrada;
	private String dtRegistro;
	private String acervo;
	private String nrLivro;
	private String nrFolha;
	private String nrRegistro;
	private String tipoLivro;
	
	private PFJsonModel pf;
	
	@Id
	@Column(name="ID_REGISTRO")
	public long getId_registro() {
		return id_registro;
	}
	public void setId_registro(long id_registro) {
		this.id_registro = id_registro;
	}
	@Column(name="CARTORIO_REGISTRO")
	public String getCartorioDeRegistro() {
		return cartorioDeRegistro;
	}
	public void setCartorioDeRegistro(String cartorioDeRegistro) {
		this.cartorioDeRegistro = cartorioDeRegistro;
	}
	@Column(name="NR_CNS")
	public String getNrCns() {
		return nrCns;
	}
	public void setNrCns(String nrCns) {
		this.nrCns = nrCns;
	}
	@Column(name="UF")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Column(name="NOME_CONJUGE1")
	public String getNomeConjuge1() {
		return nomeConjuge1;
	}
	public void setNomeConjuge1(String nomeConjuge1) {
		this.nomeConjuge1 = nomeConjuge1;
	}
	@Column(name="NOME_CONJUGE2")
	public String getNomeConjuge2() {
		return nomeConjuge2;
	}
	public void setNomeConjuge2(String nomeConjuge2) {
		this.nomeConjuge2 = nomeConjuge2;
	}
	@Column(name="NV_NOME_CONJUGE2")
	public String getNovoNomeConjuge2() {
		return novoNomeConjuge2;
	}
	public void setNovoNomeConjuge2(String novoNomeConjuge2) {
		this.novoNomeConjuge2 = novoNomeConjuge2;
	}
	@Column(name="DT_CASAMENTO")
	public String getDtCasamento() {
		return dtCasamento;
	}
	public void setDtCasamento(String dtCasamento) {
		this.dtCasamento = dtCasamento;
	}
	@Column(name="MATRICULA")
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Column(name="DT_ENTRADA")
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	@Column(name="DT_REGISTRO")
	public String getDtRegistro() {
		return dtRegistro;
	}
	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}
	@Column(name="ACERVO")
	public String getAcervo() {
		return acervo;
	}
	public void setAcervo(String acervo) {
		this.acervo = acervo;
	}
	@Column(name="NR_LIVRO")
	public String getNrLivro() {
		return nrLivro;
	}
	public void setNrLivro(String nrLivro) {
		this.nrLivro = nrLivro;
	}
	@Column(name="NR_FOLHA")
	public String getNrFolha() {
		return nrFolha;
	}
	public void setNrFolha(String nrFolha) {
		this.nrFolha = nrFolha;
	}
	@Column(name="NR_REGISTRO")
	public String getNrRegistro() {
		return nrRegistro;
	}
	public void setNrRegistro(String nrRegistro) {
		this.nrRegistro = nrRegistro;
	}
	@Column(name="TIPO_LIVRO")
	public String getTipoLivro() {
		return tipoLivro;
	}
	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}
	
	@ManyToOne
	@JoinColumn(name = "ID_PF")
	public PFJsonModel getPf() {
		return pf;
	}

	public void setPf(PFJsonModel pf) {
		this.pf = pf;
	}
	
}
