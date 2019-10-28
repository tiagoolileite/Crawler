package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ResultadoCensecModel;
import br.com.fiap.service.DBConect;

public class ResultadoCensecRepository {
	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public ResultadoCensecRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public long savePf(ResultadoCensecModel resultadoCensec, PFJsonModel pfJson) {
		sql = "INSERT INTO TB_CENSEC("
				+ "ID_CENSEC, " + 
				"NOME_EMPRESA, " + 
				"CPF_CNPJ, " + 
				"IDENTIDADE, " + 
				"CARTORIO, " + 
				"TIPO_ATO, " + 
				"LIVRO, " + 
				"FOLHA, " + 
				"DT_ATO, "+
				"CARGA, " + 
				"ATO_CARGA, " + 
				"DT_ATO_CARGA, " + 
				"LIVRO_CARGA, " + 
				"COMP_LIVRO_CARGA, " + 
				"FOLHA_CARGA, " + 
				"COMP_FOLHA_CARGA, " + 
				"ID_PF)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT CENSEC_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idCensec = rsSeq.getLong(1);
			p.setLong(1, idCensec);
			p.setString(2, resultadoCensec.getNomeEmpresa());
			p.setString(3, resultadoCensec.getCpfCnpj());
			p.setString(4, resultadoCensec.getIdentidade());
			p.setString(5, resultadoCensec.getCartorio());
			p.setString(6, resultadoCensec.getTipoAto());
			p.setString(7, resultadoCensec.getLivro());
			p.setString(8, resultadoCensec.getFolha());
			p.setString(9, resultadoCensec.getDtAto());
			p.setString(10, resultadoCensec.getCarga());
			p.setString(11, resultadoCensec.getAtoCarga());
			p.setString(12, resultadoCensec.getDtAtoCarga());
			p.setString(13, resultadoCensec.getLivroCarga());
			p.setString(14, resultadoCensec.getComplementLivroCarga());
			p.setString(15, resultadoCensec.getFolhaCarga());
			p.setString(16, resultadoCensec.getComplementoFolhaCarga());
			p.setLong(17, pfJson.getIdPf());
			p.execute();
			
			connection.commit();
			
			return idCensec;
		}catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}

	public long savePj(ResultadoCensecModel resultadoCensec, PJJsonModel pjJson) {
		sql = "INSERT INTO TB_CENSEC("
				+ "ID_CENSEC, " + 
				"NOME_EMPRESA, " + 
				"CPF_CNPJ, " + 
				"IDENTIDADE, " + 
				"CARTORIO, " + 
				"TIPO_ATO, " + 
				"LIVRO, " + 
				"FOLHA, " + 
				"DT_ATO, "+
				"CARGA, " + 
				"ATO_CARGA, " + 
				"DT_ATO_CARGA, " + 
				"LIVRO_CARGA, " + 
				"COMP_LIVRO_CARGA, " + 
				"FOLHA_CARGA, " + 
				"COMP_FOLHA_CARGA, " + 
				"ID_PJ)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT CENSEC_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idCensec = rsSeq.getLong(1);
			p.setLong(1, idCensec);
			p.setString(2, resultadoCensec.getNomeEmpresa());
			p.setString(3, resultadoCensec.getCpfCnpj());
			p.setString(4, resultadoCensec.getIdentidade());
			p.setString(5, resultadoCensec.getCartorio());
			p.setString(6, resultadoCensec.getTipoAto());
			p.setString(7, resultadoCensec.getLivro());
			p.setString(8, resultadoCensec.getFolha());
			p.setString(9, resultadoCensec.getDtAto());
			p.setString(10, resultadoCensec.getCarga());
			p.setString(11, resultadoCensec.getAtoCarga());
			p.setString(12, resultadoCensec.getDtAtoCarga());
			p.setString(13, resultadoCensec.getLivroCarga());
			p.setString(14, resultadoCensec.getComplementLivroCarga());
			p.setString(15, resultadoCensec.getFolhaCarga());
			p.setString(16, resultadoCensec.getComplementoFolhaCarga());
			p.setLong(17, pjJson.getIdPj());
			p.execute();
			
			connection.commit();
			
			return idCensec;
		}catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
}
