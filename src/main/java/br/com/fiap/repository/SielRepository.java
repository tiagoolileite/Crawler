package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SielModel;
import br.com.fiap.service.DBConect;

public class SielRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public SielRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void save(SielModel siel, PFJsonModel pfjson) {
		sql = "INSERT INTO TB_SIEL("
				+ "ID_SIEL, " + 
				"NOME, " + 
				"TITULO, " + 
				"DT_NASCIMENTO, " + 
				"ZONA, " + 
				"ENDERECO, " + 
				"MUNICIPIO, " + 
				"UF, " + 
				"DT_DOMICILIO, " + 
				"NOME_PAI, " + 
				"NOME_MAE, " + 
				"NATURALIDADE, " + 
				"COD_VALIDACAO, " + 
				"ID_PF)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT SIEL_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idSiel = rsSeq.getLong(1);
			p.setLong(1, idSiel);
			p.setString(2, siel.getNome());
			p.setString(3, siel.getTitulo());
			p.setString(4, siel.getDtNascimento());
			p.setString(5, siel.getZona());
			p.setString(6, siel.getEndereco());
			p.setString(7, siel.getMunicipio());
			p.setString(8, siel.getUf());
			p.setString(9, siel.getDtDomicilio());
			p.setString(10, siel.getNomePai());
			p.setString(11, siel.getNomeMae());
			p.setString(12, siel.getNaturalidade());
			p.setString(13, siel.getCodValidacao());
			p.setLong(14, pfjson.getIdPf());
			p.execute();
			
			connection.commit();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
