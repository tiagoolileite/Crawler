package br.com.fiap.model;

public class JucespModel {
	private long idJucesp;
	private String razaoSocial;
	private String nireMatriz;
	private String tipoEmpresa;
	private String dtConstituicao;
	private String inicioAtividade;
	private String cnpj;
	private String objetivo;
	private String capital;
	private String logradouro;
	private String nr;
	private String bairro;
	private String municipio;
	private String complemento;
	private String cep;
	private String uf;
	private long idPj;
	
	
	
	
	public JucespModel() {
	}
	
	public long getIdJucesp() {
		return idJucesp;
	}
	public void setIdJucesp(long idJucesp) {
		this.idJucesp = idJucesp;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNireMatriz() {
		return nireMatriz;
	}
	public void setNireMatriz(String nireMatriz) {
		this.nireMatriz = nireMatriz;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	public String getDtConstituicao() {
		return dtConstituicao;
	}
	public void setDtConstituicao(String dtConstituicao) {
		this.dtConstituicao = dtConstituicao;
	}
	public String getInicioAtividade() {
		return inicioAtividade;
	}
	public void setInicioAtividade(String inicioAtividade) {
		this.inicioAtividade = inicioAtividade;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	public long getIdPj() {
		return idPj;
	}

	public void setIdPj(long idPj) {
		this.idPj = idPj;
	}

	public JucespModel(long idJucesp, String razaoSocial, String nireMatriz, String tipoEmpresa, String dtConstituicao,
			String inicioAtividade, String cnpj, String objetivo, String capital, String logradouro, String nr,
			String bairro, String municipio, String complemento, String cep, String uf, long idPj) {
		super();
		this.idJucesp = idJucesp;
		this.razaoSocial = razaoSocial;
		this.nireMatriz = nireMatriz;
		this.tipoEmpresa = tipoEmpresa;
		this.dtConstituicao = dtConstituicao;
		this.inicioAtividade = inicioAtividade;
		this.cnpj = cnpj;
		this.objetivo = objetivo;
		this.capital = capital;
		this.logradouro = logradouro;
		this.nr = nr;
		this.bairro = bairro;
		this.municipio = municipio;
		this.complemento = complemento;
		this.cep = cep;
		this.uf = uf;
		this.idPj = idPj;
	}

	

}
