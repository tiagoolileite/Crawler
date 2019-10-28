package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.JucespModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class JucespRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public JucespRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void save(JucespModel jucesp, PJJsonModel pjJson) {
		sql = "INSERT INTO TB_JUCESP("
				+ "ID_JUCESP, " + 
				"RAZAO_SOCIAL, " + 
				"NIRE_MATRIZ, " + 
				"TIPO_EMPRESA, " + 
				"DT_CONSTITUICAO, " + 
				"INICIO_ATIVIDADE, " + 
				"CNPJ, " + 
				"OBJETIVO, " + 
				"CAPITAL, " + 
				"LOGRADOURO, " + 
				"NR, " + 
				"BAIRRO, " + 
				"MUNICIPIO, " +
				"COMPLEMENTO, " +
				"CEP, " +
				"UF, " +
				"ID_PJ)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT JUCESP_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idJucesp = rsSeq.getLong(1);
			p.setLong(1, idJucesp);
			p.setString(2, jucesp.getRazaoSocial());
			p.setString(3, jucesp.getNireMatriz());
			p.setString(4, jucesp.getTipoEmpresa());
			p.setString(5, jucesp.getDtConstituicao());
			p.setString(6, jucesp.getInicioAtividade());
			p.setString(7, jucesp.getCnpj());
			p.setString(8, jucesp.getObjetivo());
			p.setString(9, jucesp.getCapital());
			p.setString(10, jucesp.getLogradouro());
			p.setString(11, jucesp.getNr());
			p.setString(12, jucesp.getBairro());
			p.setString(13, jucesp.getMunicipio());
			p.setString(14, jucesp.getComplemento());
			p.setString(15, jucesp.getCep());
			p.setString(16, jucesp.getUf());
			p.setLong(17, pjJson.getIdPj());
			p.execute();
			
			connection.commit();
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
