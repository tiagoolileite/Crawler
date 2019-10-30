package br.com.fiap.model;

public class CadespModel {
	
	private Long idCadesp;
	private String iE;
	private String situacaoCadesp;
	private String dtInstituicaoEstado;
	private String nomeEmpresarial;
	private String regimeEstadual;
	private String drt;
	private String postoFiscal;
	private String nire;
	private String ocorrenciaFiscal;
	private String tipoUnidade;
	private String dtInicioIe;
	private String formasAtuacao;
	
	private PJJsonModel pj;
	
	public CadespModel() {
	}
	public CadespModel(Long idCadesp, String iE, String situacaoCadesp, String dtInstituicaoEstado,
			String nomeEmpresarial, String regimeEstadual, String drt, String postoFiscal, String nire,
			String ocorrenciaFiscal, String tipoUnidade, String dtInicioIe, String formasAtuacao, PJJsonModel pj) {
		super();
		this.idCadesp = idCadesp;
		this.iE = iE;
		this.situacaoCadesp = situacaoCadesp;
		this.dtInstituicaoEstado = dtInstituicaoEstado;
		this.nomeEmpresarial = nomeEmpresarial;
		this.regimeEstadual = regimeEstadual;
		this.drt = drt;
		this.postoFiscal = postoFiscal;
		this.nire = nire;
		this.ocorrenciaFiscal = ocorrenciaFiscal;
		this.tipoUnidade = tipoUnidade;
		this.dtInicioIe = dtInicioIe;
		this.formasAtuacao = formasAtuacao;
		this.pj = pj;
	}
	public Long getIdCadesp() {
		return idCadesp;
	}
	public void setIdCadesp(Long idCadesp) {
		this.idCadesp = idCadesp;
	}
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE;
	}
	public String getSituacaoCadesp() {
		return situacaoCadesp;
	}
	public void setSituacaoCadesp(String situacaoCadesp) {
		this.situacaoCadesp = situacaoCadesp;
	}
	public String getDtInstituicaoEstado() {
		return dtInstituicaoEstado;
	}
	public void setDtInstituicaoEstado(String dtInstituicaoEstado) {
		this.dtInstituicaoEstado = dtInstituicaoEstado;
	}
	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}
	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}
	public String getRegimeEstadual() {
		return regimeEstadual;
	}
	public void setRegimeEstadual(String regimeEstadual) {
		this.regimeEstadual = regimeEstadual;
	}
	public String getDrt() {
		return drt;
	}
	public void setDrt(String drt) {
		this.drt = drt;
	}
	public String getPostoFiscal() {
		return postoFiscal;
	}
	public void setPostoFiscal(String postoFiscal) {
		this.postoFiscal = postoFiscal;
	}
	public String getNire() {
		return nire;
	}
	public void setNire(String nire) {
		this.nire = nire;
	}
	public String getOcorrenciaFiscal() {
		return ocorrenciaFiscal;
	}
	public void setOcorrenciaFiscal(String ocorrenciaFiscal) {
		this.ocorrenciaFiscal = ocorrenciaFiscal;
	}
	public String getTipoUnidade() {
		return tipoUnidade;
	}
	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}
	public String getDtInicioIe() {
		return dtInicioIe;
	}
	public void setDtInicioIe(String dtInicioIe) {
		this.dtInicioIe = dtInicioIe;
	}
	public String getFormasAtuacao() {
		return formasAtuacao;
	}
	public void setFormasAtuacao(String formasAtuacao) {
		this.formasAtuacao = formasAtuacao;
	}
	public PJJsonModel getPj() {
		return pj;
	}
	public void setPj(PJJsonModel pj) {
		this.pj = pj;
	}
	
	
}
