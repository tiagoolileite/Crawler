package br.com.fiap.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PF")
public class PFJsonModel {
	
	private long idPf;
	private String cpf;
	private String rg;
	private String nome;
	private Date dtNascimento;
	private Date dtConsulta;
	private String status;
	private String nrProcessoArpensp;
	private String nrProcessoSiel;
	private String pisPasep;
	private String placa;
	private String matriculaSapSivec;
	
	private List<ProcessoArispModel> processosArisp;
	private RegistroArpenspModel registroArpensp;
	private CagedModel registroCaged;
	private List<ResultadoCensecModel> resultadosCensec;
	
	public PFJsonModel() {

	}
	
	public PFJsonModel(long idPf, String cpf, String rg, String nome, Date dtNascimento, Date dtConsulta, String status,
			String nrProcessoArpensp, String nrProcessoSiel, String pisPasep, String placa, String matriculaSapSivec,
			List<ProcessoArispModel> processosArisp) {
		super();
		this.idPf = idPf;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.dtConsulta = dtConsulta;
		this.status = status;
		this.nrProcessoArpensp = nrProcessoArpensp;
		this.nrProcessoSiel = nrProcessoSiel;
		this.pisPasep = pisPasep;
		this.placa = placa;
		this.matriculaSapSivec = matriculaSapSivec;
		this.processosArisp = processosArisp;
	}
	public PFJsonModel(long idPf, String cpf, String rg, String nome, Date dtNascimento, Date dtConsulta, String status,
			String nrProcessoArpensp, String nrProcessoSiel, String pisPasep, String placa, String matriculaSapSivec) {
		super();
		this.idPf = idPf;
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.dtConsulta = dtConsulta;
		this.status = status;
		this.nrProcessoArpensp = nrProcessoArpensp;
		this.nrProcessoSiel = nrProcessoSiel;
		this.pisPasep = pisPasep;
		this.placa = placa;
		this.matriculaSapSivec = matriculaSapSivec;
	}
	@Id
	@SequenceGenerator(name = "PF_SEQ", sequenceName = "PF_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PF_SEQ")
	@Column(name = "ID_PF")
	public long getIdPf() {
		return idPf;
	}
	public void setIdPf(long idPf) {
		this.idPf = idPf;
	}
	@Column(name = "CPF")
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Column(name = "RG")
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "DT_NASCIMENTO")
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	@Column(name = "DT_CONSULTA")
	public Date getDtConsulta() {
		return dtConsulta;
	}
	public void setDtConsulta(Date dtConsulta) {
		this.dtConsulta = dtConsulta;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "NR_PROCESSO_ARPENSP")
	public String getNrProcessoArpensp() {
		return nrProcessoArpensp;
	}
	public void setNrProcessoArpensp(String nrProcessoArpensp) {
		this.nrProcessoArpensp = nrProcessoArpensp;
	}
	@Column(name = "NR_PROCESSO_SIEL")
	public String getNrProcessoSiel() {
		return nrProcessoSiel;
	}
	public void setNrProcessoSiel(String nrProcessoSiel) {
		this.nrProcessoSiel = nrProcessoSiel;
	}
	@Column(name = "PIS_PASEP")
	public String getPisPasep() {
		return pisPasep;
	}
	public void setPisPasep(String pisPasep) {
		this.pisPasep = pisPasep;
	}
	@Column(name = "PLACA")
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Column(name = "MATRICULA_SAP")
	public String getMatriculaSapSivec() {
		return matriculaSapSivec;
	}
	public void setMatriculaSapSivec(String matriculaSapSivec) {
		this.matriculaSapSivec = matriculaSapSivec;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pf")
	public List<ProcessoArispModel> getProcessosArisp() {
		return processosArisp;
	}
	public void setProcessosArisp(List<ProcessoArispModel> processosArisp) {
		this.processosArisp = processosArisp;
	}
	
	

	public RegistroArpenspModel getRegistroArpensp() {
		return registroArpensp;
	}

	public void setRegistroArpensp(RegistroArpenspModel registroArpensp) {
		this.registroArpensp = registroArpensp;
	}

	public CagedModel getRegistroCaged() {
		return registroCaged;
	}

	public void setRegistroCaged(CagedModel registroCaged) {
		this.registroCaged = registroCaged;
	}

	public List<ResultadoCensecModel> getResultadosCensec() {
		return resultadosCensec;
	}

	public void setResultadosCensec(List<ResultadoCensecModel> resultadosCensec) {
		this.resultadosCensec = resultadosCensec;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		builder.append("Id: ").append(idPf).append(", ")
			   .append("Cpf: ").append(cpf).append(", ")
			   .append("RG: ").append(rg).append(", ")
			   .append("Nome: ").append(nome).append(", ")
			   .append("Data Consulta: ").append(sdf.format(dtConsulta)).append(", ")
			   .append("Status: ").append(status)
			   .append("Nr processo Arpensp: ").append(nrProcessoArpensp)
			   .append("Pis/Pasep: ").append(pisPasep)
			   .append("Placa: ").append(placa)
			   .append("Matricula SAP: ").append(matriculaSapSivec)
			   .append("\n");
			   
		return builder.toString();
	}
}
