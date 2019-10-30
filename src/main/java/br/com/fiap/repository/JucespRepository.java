package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.JucespModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class JucespRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
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

	public List<JucespModel> findAllByIdPj(PJJsonModel pj) {
		List<JucespModel> jucesps = new ArrayList<JucespModel>();
		sql = "select * from tb_jucesp"
				+ " where id_pj = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pj.getIdPj());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idJucesp = rs.getLong(1);
				String razaoSocial = rs.getString(2);
				String nireMatriz = rs.getString(3);
				String tipoEmpresa = rs.getString(4);
				String dtConstituicao = rs.getString(5);
				String inicioAtividade = rs.getString(6);
				String cnpj = rs.getString(7);
				String objetivo = rs.getString(8);
				String capital = rs.getString(9);
				String logradouro = rs.getString(10);
				String nr = rs.getString(11);
				String bairro = rs.getString(12);
				String municipio = rs.getString(13);
				String complemento = rs.getString(14);
				String cep = rs.getString(15);
				String uf = rs.getString(16);
				long idPj = rs.getLong(17);
				
				JucespModel jucesp = new JucespModel(idJucesp, razaoSocial, nireMatriz, tipoEmpresa, dtConstituicao, inicioAtividade, cnpj, objetivo, capital, logradouro, nr, bairro, municipio, complemento, cep, uf, idPj);
				jucesps.add(jucesp);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return jucesps;
	}

}
