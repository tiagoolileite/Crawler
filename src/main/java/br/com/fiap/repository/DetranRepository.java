package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.DetranModel;
import br.com.fiap.model.PFJsonModel;
import br.com.fiap.service.DBConect;

public class DetranRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
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

	public List<DetranModel> findAllById(PFJsonModel pfJson) {
		List<DetranModel> detrans = new ArrayList<DetranModel>();
		sql = "select * from tb_detran"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idDetran = rs.getLong(1);
				String renach = rs.getString(2);
				String categoria = rs.getString(3);
				String emissao = rs.getString(4);
				String dtNascimento = rs.getString(5);
				String nomeCondutor = rs.getString(6);
				String nomePai = rs.getString(7);
				String nomeMae = rs.getString(8);
				String registro = rs.getString(9);
				String tipografico = rs.getString(10);
				String identidade = rs.getString(11);
				String cpf = rs.getString(12);
				long idPf = rs.getLong(13);
				
				DetranModel detran = new DetranModel(idDetran, renach, categoria, emissao, dtNascimento, nomeCondutor, nomePai, nomeMae, registro, tipografico, identidade, cpf, idPf);
				detrans.add(detran);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return detrans;
	}

}
