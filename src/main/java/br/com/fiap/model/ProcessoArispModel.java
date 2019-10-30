package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ARISP")
@SequenceGenerator(name = "PROCESSO_SEQ", sequenceName = "PROCESSO_SEQ", initialValue = 1, allocationSize = 1)
public class ProcessoArispModel {

	private long idProcessoArisp;
	private String cidade;
	private String cartorio;
	private String matricula;
	
	private PFJsonModel pf;
	private PJJsonModel pj;
	
	public ProcessoArispModel() {
	}

	public ProcessoArispModel(long idProcessoArisp, String cidade, String cartorio, String matricula, PFJsonModel pf) {
		super();
		this.idProcessoArisp = idProcessoArisp;
		this.cidade = cidade;
		this.cartorio = cartorio;
		this.matricula = matricula;
		this.pf = pf;
	}

	public ProcessoArispModel(long idProcessoArisp, String cidade, String cartorio, String matricula, PJJsonModel pj) {
		super();
		this.idProcessoArisp = idProcessoArisp;
		this.cidade = cidade;
		this.cartorio = cartorio;
		this.matricula = matricula;
		this.pj = pj;
	}

	public ProcessoArispModel(String cidade, String cartorio, String matricula) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="ID_PROCESSO")
	public long getIdProcessoArisp() {
		return idProcessoArisp;
	}

	public void setIdProcessoArisp(long idProcessoArisp) {
		this.idProcessoArisp = idProcessoArisp;
	}

	@Column(name="CIDADE")
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="CARTORIO")
	public String getCartorio() {
		return cartorio;
	}

	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}

	@Column(name="MATRICULA")
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PF")
	public PFJsonModel getPf() {
		return pf;
	}

	public void setPf(PFJsonModel pf) {
		this.pf = pf;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PJ")
	public PJJsonModel getPj() {
		return pj;
	}

	public void setPj(PJJsonModel pj) {
		this.pj = pj;
	}

	
}
