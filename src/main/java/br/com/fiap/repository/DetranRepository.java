package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.DetranModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.service.DBConect;

public class DetranRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public DetranRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void savePf(DetranModel detran, PFJsonModel pfJson) {
		sql = "INSERT INTO TB_DETRAN("
				+ "ID_DETRAN, " + 
				"RENACH, " + 
				"CATEGORIA, " + 
				"EMISSAO, " + 
				"DT_NASCIMENTO, " + 
				"NOME_CONDUTOR, " + 
				"NOME_PAI, " + 
				"NOME_MAE, " + 
				"REGISTRO, " + 
				"TIPOGRAFICO, " + 
				"IDENTIDADE, " + 
				"CPF, " + 
				"ID_PF)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT DETRAN_SEQ.NEXTVAL FROM DUAL";
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idDetran = rsSeq.getLong(1);
			p.setLong(1, idDetran);
			p.setString(2, detran.getRenach());
			p.setString(3, detran.getCategoria());
			p.setString(4, detran.getEmissao());
			p.setString(5, detran.getDtNascimento());
			p.setString(6, detran.getNomeCondutor());
			p.setString(7, detran.getNomePai());
			p.setString(8, detran.getNomeMae());
			p.setString(9, detran.getRegistro());
			p.setString(10, detran.getTipografico());
			p.setString(11, detran.getIdentidade());
			p.setString(12, detran.getCpf());
			p.setLong(13, pfJson.getIdPf());
			p.execute();
			
			connection.commit();
		}catch (Exception e) {
			System.out.println(e);
		}		
	}

}
