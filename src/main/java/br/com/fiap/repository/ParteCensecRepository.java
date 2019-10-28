package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ParteCensecModel;
import br.com.fiap.model.ResultadoCensecModel;
import br.com.fiap.service.DBConect;

public class ParteCensecRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public ParteCensecRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void savePf(ParteCensecModel parteModel, ResultadoCensecModel resultadoCensec, PFJsonModel pfJson) {
		sql = "INSERT INTO TB_PARTE_CENSEC("
				+ "ID_PARTE_CENSEC, " + 
				"NOME, " + 
				"CPF_CNPJ, " + 
				"QUALIDADE, " + 
				"ID_CENSEC, " + 
				"ID_PF)"
				+ " VALUES(?,?,?,?,?,?)";
		sequence = "SELECT PARTE_CENSEC_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idParteCensec = rsSeq.getLong(1);
			p.setLong(1, idParteCensec);
			p.setString(2, parteModel.getNome());
			p.setString(3, parteModel.getCpfCnpj());
			p.setString(4, parteModel.getQualidade());
			p.setLong(5, resultadoCensec.getIdCensec());
			p.setLong(6, pfJson.getIdPf());
			p.execute();
			
			connection.commit();
		}catch (Exception e) {
			System.out.println(e);
		}		
	}

	public void savePj(ParteCensecModel parteModel, ResultadoCensecModel resultadoCensec, PJJsonModel pjJson) {
		sql = "INSERT INTO TB_PARTE_CENSEC("
				+ "ID_PARTE_CENSEC, " + 
				"NOME, " + 
				"CPF_CNPJ, " + 
				"QUALIDADE, " + 
				"ID_CENSEC, " + 
				"ID_PJ)"
				+ " VALUES(?,?,?,?,?,?)";
		sequence = "SELECT PARTE_CENSEC_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idParteCensec = rsSeq.getLong(1);
			p.setLong(1, idParteCensec);
			p.setString(2, parteModel.getNome());
			p.setString(3, parteModel.getCpfCnpj());
			p.setString(4, parteModel.getQualidade());
			p.setLong(5, resultadoCensec.getIdCensec());
			p.setLong(6, pjJson.getIdPj());
			p.execute();
			
			connection.commit();
		}catch (Exception e) {
			System.out.println(e);
		}		
	}

}
