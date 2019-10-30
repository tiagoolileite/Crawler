package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SielModel;
import br.com.fiap.service.DBConect;

public class SielRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
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
/*
	public List<SielModel> findAllById(PFJsonModel pfJson) {
		List<SielModel> siels = new ArrayList<SielModel>();
		sql = "select * from tb_siel"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idSiel = rs.getLong(1);
				String nomeEmpresa = rs.getString(2);
				String cpfCnpj = rs.getString(3);
				String identidade = rs.getString(4);
				String cartorio = rs.getString(5);
				String tipoAto = rs.getString(6);
				String livro = rs.getString(7);
				String folha = rs.getString(8);
				String dtAto = rs.getString(9);
				String carga = rs.getString(10);
				String atoCarga = rs.getString(11);
				String dtAtoCarga = rs.getString(12);
				String livroCarga = rs.getString(13);
				String complementoLivroCarga = rs.getString(14);
				String folhaCarga = rs.getString(15);
				String complementoFolhaCarga = rs.getString(16);
				
				ResultadoCensecModel censec = new ResultadoCensecModel(idCensec, nomeEmpresa, cpfCnpj, identidade, cartorio, tipoAto, livro, folha, dtAto, carga, atoCarga, dtAtoCarga, livroCarga, complementoLivroCarga, folhaCarga, complementoFolhaCarga, pfJson);
				censecs.add(censec);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return censecs;

	}
		*/

	public List<SielModel> findAllById(PFJsonModel pfJson) {
		List<SielModel> siels = new ArrayList<SielModel>();
		sql = "select * from tb_siel"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idSiel = rs.getLong(1);
				String nome = rs.getString(2);
				String titulo = rs.getString(3);
				String dtNascimento = rs.getString(4);
				String zona = rs.getString(5);
				String endereco = rs.getString(6);
				String municipio = rs.getString(7);
				String uf = rs.getString(8);
				String dtDomicilio = rs.getString(9);
				String nomePai = rs.getString(10);
				String nomeMae = rs.getString(11);
				String naturalidade = rs.getString(12);
				String codValidacao = rs.getString(13);
				long idPf = rs.getLong(14);
				
				SielModel siel = new SielModel(idSiel, nome, titulo, dtNascimento, zona, endereco, municipio, uf, dtDomicilio, nomePai, nomeMae, naturalidade, codValidacao, idPf);
				siels.add(siel);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return siels;
	}
}
