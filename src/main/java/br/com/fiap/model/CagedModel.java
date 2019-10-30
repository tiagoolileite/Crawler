package br.com.fiap.model;

public class CagedModel {
	
	public CagedModel(Long idCaged, String logradouro, String bairroDistrito, String municipio, String uf, String cep,
			String nomContato, String cpfContato, String telContato, String emailContato, String ramalContato,
			String nrFiliais, String admissoes, String variacaoAbsoluta, String totalVinculos, String desligamentos,
			String primeiroDia, String ultimoDia, String ctpsSerie, String situacaoPis, String nacionalidade,
			String grauInstrucao, String deficiente, String sexo, String racaCor, String tempoTrabalho, String rais,
			PJJsonModel pj) {
		super();
		this.idCaged = idCaged;
		this.logradouro = logradouro;
		this.bairroDistrito = bairroDistrito;
		this.municipio = municipio;
		this.uf = uf;
		this.cep = cep;
		this.nomContato = nomContato;
		this.cpfContato = cpfContato;
		this.telContato = telContato;
		this.emailContato = emailContato;
		this.ramalContato = ramalContato;
		this.nrFiliais = nrFiliais;
		this.admissoes = admissoes;
		this.variacaoAbsoluta = variacaoAbsoluta;
		this.totalVinculos = totalVinculos;
		this.desligamentos = desligamentos;
		this.primeiroDia = primeiroDia;
		this.ultimoDia = ultimoDia;
		this.ctpsSerie = ctpsSerie;
		this.situacaoPis = situacaoPis;
		this.nacionalidade = nacionalidade;
		this.grauInstrucao = grauInstrucao;
		this.deficiente = deficiente;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.tempoTrabalho = tempoTrabalho;
		this.rais = rais;
		this.pj = pj;
	}
	private Long idCaged;
	private String logradouro;
	private String bairroDistrito;
	private String municipio;
	private String uf;
	private String cep;
	private String nomContato;
	private String cpfContato;
	private String telContato;
	private String emailContato;
	private String ramalContato;
	private String nrFiliais;
	private String admissoes;
	private String variacaoAbsoluta;
	private String totalVinculos;
	private String desligamentos;
	private String primeiroDia;
	private String ultimoDia;
	private String pisBase;
	private String ctpsSerie;
	private String situacaoPis;
	private String nacionalidade;
	private String grauInstrucao;
	private String deficiente;
	private String sexo;
	private String racaCor;
	private String tempoTrabalho;
	private String rais;
	
	private PFJsonModel pf;
	private PJJsonModel pj;
	
	public CagedModel() {
	}
	
	public CagedModel(Long idCaged, String logradouro, String bairroDistrito, String municipio, String uf, String cep,
			String nomContato, String cpfContato, String telContato, String emailContato, String ramalContato,
			String nrFiliais, String ctpsSerie, String situacaoPis, String nacionalidade, String grauInstrucao,
			String deficiente, String sexo, String racaCor, String tempoTrabalho, String rais, PFJsonModel pf) {
		super();
		this.idCaged = idCaged;
		this.logradouro = logradouro;
		this.bairroDistrito = bairroDistrito;
		this.municipio = municipio;
		this.uf = uf;
		this.cep = cep;
		this.nomContato = nomContato;
		this.cpfContato = cpfContato;
		this.telContato = telContato;
		this.emailContato = emailContato;
		this.ramalContato = ramalContato;
		this.nrFiliais = nrFiliais;
		this.ctpsSerie = ctpsSerie;
		this.situacaoPis = situacaoPis;
		this.nacionalidade = nacionalidade;
		this.grauInstrucao = grauInstrucao;
		this.deficiente = deficiente;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.tempoTrabalho = tempoTrabalho;
		this.rais = rais;
		this.pf = pf;
	}
	
	public CagedModel(Long idCaged, String logradouro, String bairroDistrito, String municipio, String uf, String cep,
			String nomContato, String cpfContato, String telContato, String emailContato, String ramalContato,
			String nrFiliais, String admissoes, String variacaoAbsoluta, String totalVinculos, String desligamentos,
			String primeiroDia, String ultimoDia, String pisBase, String ctpsSerie, String situacaoPis,
			String nacionalidade, String grauInstrucao, String deficiente, String sexo, String racaCor,
			String tempoTrabalho, String rais, PFJsonModel pf) {
		super();
		this.idCaged = idCaged;
		this.logradouro = logradouro;
		this.bairroDistrito = bairroDistrito;
		this.municipio = municipio;
		this.uf = uf;
		this.cep = cep;
		this.nomContato = nomContato;
		this.cpfContato = cpfContato;
		this.telContato = telContato;
		this.emailContato = emailContato;
		this.ramalContato = ramalContato;
		this.nrFiliais = nrFiliais;
		this.admissoes = admissoes;
		this.variacaoAbsoluta = variacaoAbsoluta;
		this.totalVinculos = totalVinculos;
		this.desligamentos = desligamentos;
		this.primeiroDia = primeiroDia;
		this.ultimoDia = ultimoDia;
		this.pisBase = pisBase;
		this.ctpsSerie = ctpsSerie;
		this.situacaoPis = situacaoPis;
		this.nacionalidade = nacionalidade;
		this.grauInstrucao = grauInstrucao;
		this.deficiente = deficiente;
		this.sexo = sexo;
		this.racaCor = racaCor;
		this.tempoTrabalho = tempoTrabalho;
		this.rais = rais;
		this.pf = pf;
	}
	public Long getIdCaged() {
		return idCaged;
	}
	public void setIdCaged(Long idCaged) {
		this.idCaged = idCaged;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairroDistrito() {
		return bairroDistrito;
	}
	public void setBairroDistrito(String bairroDistrito) {
		this.bairroDistrito = bairroDistrito;
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNomContato() {
		return nomContato;
	}
	public void setNomContato(String nomContato) {
		this.nomContato = nomContato;
	}
	public String getCpfContato() {
		return cpfContato;
	}
	public void setCpfContato(String cpfContato) {
		this.cpfContato = cpfContato;
	}
	public String getTelContato() {
		return telContato;
	}
	public void setTelContato(String telContato) {
		this.telContato = telContato;
	}
	public String getEmailContato() {
		return emailContato;
	}
	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
	public String getRamalContato() {
		return ramalContato;
	}
	public void setRamalContato(String ramalContato) {
		this.ramalContato = ramalContato;
	}
	public String getNrFiliais() {
		return nrFiliais;
	}
	public void setNrFiliais(String nrFiliais) {
		this.nrFiliais = nrFiliais;
	}
	public String getAdmissoes() {
		return admissoes;
	}
	public void setAdmissoes(String admissoes) {
		this.admissoes = admissoes;
	}
	public String getVariacaoAbsoluta() {
		return variacaoAbsoluta;
	}
	public void setVariacaoAbsoluta(String variacaoAbsoluta) {
		this.variacaoAbsoluta = variacaoAbsoluta;
	}
	public String getTotalVinculos() {
		return totalVinculos;
	}
	public void setTotalVinculos(String totalVinculos) {
		this.totalVinculos = totalVinculos;
	}
	public String getDesligamentos() {
		return desligamentos;
	}
	public void setDesligamentos(String desligamentos) {
		this.desligamentos = desligamentos;
	}
	public String getPrimeiroDia() {
		return primeiroDia;
	}
	public void setPrimeiroDia(String primeiroDia) {
		this.primeiroDia = primeiroDia;
	}
	public String getUltimoDia() {
		return ultimoDia;
	}
	public void setUltimoDia(String ultimoDia) {
		this.ultimoDia = ultimoDia;
	}
	public String getPisBase() {
		return pisBase;
	}
	public void setPisBase(String pisBase) {
		this.pisBase = pisBase;
	}
	public String getCtpsSerie() {
		return ctpsSerie;
	}
	public void setCtpsSerie(String ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}
	public String getSituacaoPis() {
		return situacaoPis;
	}
	public void setSituacaoPis(String situacaoPis) {
		this.situacaoPis = situacaoPis;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getGrauInstrucao() {
		return grauInstrucao;
	}
	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
	public String getDeficiente() {
		return deficiente;
	}
	public void setDeficiente(String deficiente) {
		this.deficiente = deficiente;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRacaCor() {
		return racaCor;
	}
	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}
	public String getTempoTrabalho() {
		return tempoTrabalho;
	}
	public void setTempoTrabalho(String tempoTrabalho) {
		this.tempoTrabalho = tempoTrabalho;
	}
	public String getRais() {
		return rais;
	}
	public void setRais(String rais) {
		this.rais = rais;
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
