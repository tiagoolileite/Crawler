package br.com.fiap.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class PJJsonModel {

	private long idPj;
		private String cnpj;
		private String razaoSocial;
		private String nomeFantasia;
		private Date dtConsulta = new Date();
		private String status = "Aguardando";
		private String matriculaArisp;
		
		private List<ProcessoArispModel> processosArisp;
		private CadespModel cadesp;
		private List<ResultadoCensecModel> resultadosCensec; 
		
		public PJJsonModel() {
		}

		public PJJsonModel(long idPj, String cnpj, String razaoSocial, String nomeFantasia, Date dtConsulta,
				String status, String matriculaArisp) {
			super();
			this.idPj = idPj;
			this.cnpj = cnpj;
			this.razaoSocial = razaoSocial;
			this.nomeFantasia = nomeFantasia;
			this.dtConsulta = dtConsulta;
			this.status = status;
			this.matriculaArisp = matriculaArisp;
		}

		@Id
		@SequenceGenerator(name = "PJ_SEQ", sequenceName = "PJ_SEQ", initialValue = 1, allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PJ_SEQ")
		@Column(name = "ID_PJ")
		public long getIdPj() {
			return idPj;
		}

		public void setIdPj(long idPj) {
			this.idPj = idPj;
		}

		@Column(name = "CNPJ")
		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		
		@Column(name = "RAZAO_SOCIAL")
		public String getRazaoSocial() {
			return razaoSocial;
		}

		public void setRazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}

		@Column(name = "NOME_FANTASIA")
		public String getNomeFantasia() {
			return nomeFantasia;
		}

		public void setNomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
		}

		@Column(name = "DT_CONSULTA")
		public Date getDtConsulta() {
			return dtConsulta;
		}
		public void setDtConsulta(Date dtConsulta) {
			this.dtConsulta = new Date();
		}	
		
		@Column(name = "STATUS")
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Column(name = "MATRICULA_ARISP")
		public String getMatriculaArisp() {
			return matriculaArisp;
		}

		public void setMatriculaArisp(String matriculaArisp) {
			this.matriculaArisp = matriculaArisp;
		}
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "pj")
		public List<ProcessoArispModel> getProcessosArisp() {
			return processosArisp;
		}

		public void setProcessosArisp(List<ProcessoArispModel> processosArisp) {
			this.processosArisp = processosArisp;
		}

		public CadespModel getCadesp() {
			return cadesp;
		}

		public void setCadesp(CadespModel cadesp) {
			this.cadesp = cadesp;
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
			
			builder.append("Id: ").append(idPj).append(", ")
				   .append("Cnpj: ").append(cnpj).append(", ")
				   .append("Razao Social: ").append(razaoSocial).append(", ")
				   .append("Nome Fantasia: ").append(nomeFantasia).append(", ")
				   .append("Data Consulta: ").append(sdf.format(dtConsulta)).append(", ")
				   .append("Status: ").append(status)
				   .append("\n");
				   
			return builder.toString();
		}
}
