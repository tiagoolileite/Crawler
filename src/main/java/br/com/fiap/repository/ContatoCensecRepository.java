package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.ContatoCensecModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.model.ResultadoCensecModel;
import br.com.fiap.service.DBConect;

public class ContatoCensecRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public ContatoCensecRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void savePf(ContatoCensecModel contatoModel, ResultadoCensecModel resultadoCensec, PFJsonModel pfJson) {
		sql = "INSERT INTO TB_CONTATO_CENSEC("
				+ "ID_CONTATO_CENSEC, " + 
				"TELEFONE, " + 
				"TIPO, " + 
				"RAMAL, " + 
				"CONTATO, " + 
				"STATUS, " + 
				"ID_CENSEC, " + 
				"ID_PF)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		sequence = "SELECT CONTATO_CENSEC_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idContatoCensec = rsSeq.getLong(1);
			p.setLong(1, idContatoCensec);
			p.setString(2, contatoModel.getTelefone());
			p.setString(3, contatoModel.getTipo());
			p.setString(4, contatoModel.getRamal());
			p.setString(5, contatoModel.getContato());
			p.setString(6, contatoModel.getStatus());
			p.setLong(7, resultadoCensec.getIdCensec());
			p.setLong(8, pfJson.getIdPf());
			p.execute();
			
			connection.commit();	
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public void savePj(ContatoCensecModel contatoModel, ResultadoCensecModel resultadoCensec, PJJsonModel pjJson) {
		sql = "INSERT INTO TB_CONTATO_CENSEC("
				+ "ID_CONTATO_CENSEC, " + 
				"TELEFONE, " + 
				"TIPO, " + 
				"RAMAL, " + 
				"CONTATO, " + 
				"STATUS, " + 
				"ID_CENSEC, " + 
				"ID_PJ)"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		sequence = "SELECT CONTATO_CENSEC_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idContatoCensec = rsSeq.getLong(1);
			p.setLong(1, idContatoCensec);
			p.setString(2, contatoModel.getTelefone());
			p.setString(3, contatoModel.getTipo());
			p.setString(4, contatoModel.getRamal());
			p.setString(5, contatoModel.getContato());
			p.setString(6, contatoModel.getStatus());
			p.setLong(7, resultadoCensec.getIdCensec());
			p.setLong(8, pjJson.getIdPj());
			p.execute();
			
			connection.commit();	
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
