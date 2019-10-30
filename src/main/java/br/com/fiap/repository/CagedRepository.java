package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.CagedModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class CagedRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
	private String sql,sequence;
	
	public CagedRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void savePj(CagedModel caged, PJJsonModel pjJson) {
		sql = "INSERT INTO TB_CAGED("
				+ "ID_CAGED, " + 
				"LOGRADOURO, " + 
				"BAIRRO_DISTRITO, " + 
				"MUNICIPIO, " + 
				"UF, " + 
				"CEP, " + 
				"NOME_CONTATO, " + 
				"CPF_CONTATO, " + 
				"TEL_CONTATO, " + 
				"EMAIL_CONTATO, " + 
				"RAMAL_CONTATO, " + 
				"NR_FILIAIS, " + 
				"ADMISSOES, " + 
				"VARIACAO_ABSOLUTA, " + 
				"TOTAL_VINCULOS, " + 
				"DESLIGAMENTOS, " + 
				"PRIMEIRO_DIA, " + 
				"ULTIMO_DIA, " + 
				"ID_PJ)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT CAGED_SEQ.NEXTVAL FROM DUAL";
		try{
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idCaged = rsSeq.getLong(1);
			p.setLong(1, idCaged);
			p.setString(2, caged.getLogradouro());
			p.setString(3, caged.getBairroDistrito());
			p.setString(4, caged.getMunicipio());
			p.setString(5, caged.getUf());
			p.setString(6, caged.getCep());
			p.setString(7, caged.getNomContato());
			p.setString(8, caged.getCpfContato());
			p.setString(9, caged.getTelContato());
			p.setString(10, caged.getEmailContato());
			p.setString(11, caged.getRamalContato());
			p.setString(12, caged.getNrFiliais());
			p.setString(13, caged.getAdmissoes());
			p.setString(14, caged.getVariacaoAbsoluta());
			p.setString(15, caged.getTotalVinculos());
			p.setString(16, caged.getDesligamentos());
			p.setString(17, caged.getPrimeiroDia());
			p.setString(18, caged.getUltimoDia());
			p.setLong(19, pjJson.getIdPj());
			p.execute();
			
			connection.commit();
			System.out.println("Parece que registrou o cadastro da caged certinho para empresa " + pjJson.getRazaoSocial() +"\n");
		}catch (Exception e) {
			System.out.println("Deu pau pra gravar o cadastro da caged da empresa " + pjJson.getRazaoSocial() + ", id " + pjJson.getIdPj()+"\n");
		}
	}

	public void savePf(CagedModel caged, PFJsonModel pfJson) {
		sql = "INSERT INTO TB_CAGED("
				+ "ID_CAGED, " + 
				"LOGRADOURO, " + 
				"BAIRRO_DISTRITO, " + 
				"MUNICIPIO, " + 
				"UF, " + 
				"CEP, " + 
				"NOME_CONTATO, " + 
				"CPF_CONTATO, " + 
				"TEL_CONTATO, " + 
				"EMAIL_CONTATO, " + 
				"RAMAL_CONTATO, " + 
				"PIS_BASE, " + 
				"CTPS_SERIE, " + 
				"SITUACAO_PIS, " + 
				"NACIONALIDADE, " + 
				"GRAU_INSTRUCAO, " + 
				"DEFICIENTE, " + 
				"SEXO, " + 
				"RACA_COR, " + 
				"TEMPO_TRABALHO, " + 
				"RAIS, " + 
				"ID_PF) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			sequence = "SELECT CAGED_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			long idCaged = rsSeq.getLong(1);
			p.setLong(1, idCaged);
			p.setString(2, caged.getLogradouro());
			p.setString(3, caged.getBairroDistrito());
			p.setString(4, caged.getMunicipio());
			p.setString(5, caged.getUf());
			p.setString(6, caged.getCep());
			p.setString(7, caged.getNomContato());
			p.setString(8, caged.getCpfContato());
			p.setString(9, caged.getTelContato());
			p.setString(10, caged.getEmailContato());
			p.setString(11, caged.getRamalContato());
			p.setString(12, caged.getPisBase());
			p.setString(13, caged.getCtpsSerie());
			p.setString(14, caged.getSituacaoPis());
			p.setString(15, caged.getNacionalidade());
			p.setString(16, caged.getGrauInstrucao());
			p.setString(17, caged.getDeficiente());
			p.setString(18, caged.getSexo());
			p.setString(19, caged.getRacaCor());
			p.setString(20, caged.getTempoTrabalho());
			p.setString(21, caged.getRais());
			p.setLong(22, pfJson.getIdPf());
			p.execute();
			
			connection.commit();
			System.out.println("Parece que gravou o cadastro da caged certinho do  "+ pfJson.getNome() + ", id " + pfJson.getIdPf() + "\n");
		}catch (Exception e) {
			System.out.println("Deu ruim ao gravar o cadastro da caged certinho do  "+ pfJson.getNome() + ", id " + pfJson.getIdPf() + "\n");
			System.out.println(e);
		}
	}

	public List<CagedModel> findAllById(PFJsonModel pfJson) {
		List<CagedModel> cageds = new ArrayList<CagedModel>();
		sql = "select * from tb_caged"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idCaged = rs.getLong(1);
				String logradouro = rs.getString(2);
				String bairroDistrito = rs.getString(3);
				String municipio = rs.getString(4);
				String uf = rs.getString(5);
				String cep = rs.getString(6);
				String nomContato = rs.getString(7);
				String cpfContato = rs.getString(8);
				String telContato = rs.getString(9);
				String emailContato = rs.getString(10);
				String ramalContato = rs.getString(11);
				String nrFiliais = rs.getString(12);
				String ctpsSerie = rs.getString(20);
				String situacaoPis = rs.getString(21);
				String nacionalidade = rs.getString(22);
				String grauInstrucao = rs.getString(23);
				String deficiente = rs.getString(24);
				String sexo = rs.getString(25);
				String racaCor = rs.getString(26);
				String tempoTrabalho = rs.getString(27);
				String rais = rs.getString(28);
				
				CagedModel caged = new CagedModel(idCaged, logradouro, bairroDistrito, municipio, uf, cep, nomContato, cpfContato, telContato, emailContato, ramalContato, nrFiliais, ctpsSerie, situacaoPis, nacionalidade, grauInstrucao, deficiente, sexo, racaCor, tempoTrabalho, rais, pfJson);
				cageds.add(caged);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return cageds;
	}

	public List<CagedModel> findAllByIdPj(PJJsonModel pj) {
		List<CagedModel> cageds = new ArrayList<CagedModel>();
		sql = "select * from tb_caged"
				+ " where id_pj = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pj.getIdPj());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idCaged = rs.getLong(1);
				String logradouro = rs.getString(2);
				String bairroDistrito = rs.getString(3);
				String municipio = rs.getString(4);
				String uf = rs.getString(5);
				String cep = rs.getString(6);
				String nomContato = rs.getString(7);
				String cpfContato = rs.getString(8);
				String telContato = rs.getString(9);
				String emailContato = rs.getString(10);
				String ramalContato = rs.getString(11);
				String nrFiliais = rs.getString(12);
				String admissoes = rs.getString(13);
				String variacaoAbsoluta = rs.getString(14);
				String totalVinculos = rs.getString(15);
				String desligamentos = rs.getString(16);
				String primeiroDia = rs.getString(17);
				String ultimoDia = rs.getString(18);
				String ctpsSerie = rs.getString(20);
				String situacaoPis = rs.getString(21);
				String nacionalidade = rs.getString(22);
				String grauInstrucao = rs.getString(23);
				String deficiente = rs.getString(24);
				String sexo = rs.getString(25);
				String racaCor = rs.getString(26);
				String tempoTrabalho = rs.getString(27);
				String rais = rs.getString(28);
				
				CagedModel caged = new CagedModel(idCaged, logradouro, bairroDistrito, municipio, uf, cep, nomContato, cpfContato, telContato, emailContato, ramalContato, nrFiliais, admissoes, variacaoAbsoluta, totalVinculos, desligamentos, primeiroDia, ultimoDia, ctpsSerie, situacaoPis, nacionalidade, grauInstrucao, deficiente, sexo, racaCor, tempoTrabalho, rais, pj);
				cageds.add(caged);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return cageds;
	}

}
