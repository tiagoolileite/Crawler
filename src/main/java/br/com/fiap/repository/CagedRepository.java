package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.CagedModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class CagedRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
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

}
