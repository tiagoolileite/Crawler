package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SivecModel;
import br.com.fiap.service.DBConect;

public class SivecRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
	private String sql,sequence;
	
	public SivecRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void save(SivecModel sivec, PFJsonModel pfJson) {
		
		sql = "INSERT INTO TB_SIVEC("
				+ "ID_SIVEC, " + 
				"NOME, " + 
				"SEXO, " + 
				"DT_NASCIMENTO, " + 
				"RG, " + 
				"TIPO_RG, " + 
				"DT_EMISSAO_RG, " + 
				"ESTADO_CIVIL, " + 
				"NATURALIZADO, " + 
				"GRAU_INSTRUCAO, " + 
				"NOME_PAI, " + 
				"NOME_MAE, " + 
				"COR_PELE, " + 
				"ALCUNHA, " + 
				"NATURALIDADE, " + 
				"POSTO_IDENTIFICACAO, " + 
				"FORMULA_FUNDAMENTAL, " + 
				"COR_OLHOS, " + 
				"CABELO, " + 
				"PROFISSAO, " + 
				"ENDERECO_RESIDENCIAL, " + 
				"ENDERECO_TRABALHO, " +
				"ID_PF)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT SIVEC_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idSivec = rsSeq.getLong(1);
			p.setLong(1, idSivec);
			p.setString(2, sivec.getNome());
			p.setString(3, sivec.getSexo());
			p.setString(4, sivec.getDtNascimento());
			p.setString(5, sivec.getRg());
			p.setString(6, sivec.getTipoRg());
			p.setString(7, sivec.getDtEmissaoRg());
			p.setString(8, sivec.getEstadoCivil());
			p.setString(9, sivec.getNaturalizado());
			p.setString(10, sivec.getGrauInstrucao());
			p.setString(11, sivec.getNomePai());
			p.setString(12, sivec.getNomeMae());
			p.setString(13, sivec.getCorPele());
			p.setString(14, sivec.getAlcunha());
			p.setString(15, sivec.getNaturalidade());
			p.setString(16, sivec.getPostoIdentificacao());
			p.setString(17, sivec.getFormulaFundamental());
			p.setString(18, sivec.getCorOlhos());
			p.setString(19, sivec.getCabelo());
			p.setString(20, sivec.getProfissao());
			p.setString(21, sivec.getEnderecoResidencial());
			p.setString(22, sivec.getEnderecoTrabalho());
			p.setLong(23, pfJson.getIdPf());
			p.execute();
			
			connection.commit();
			}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<SivecModel> findAllById(PFJsonModel pfJson) {
		List<SivecModel> sivecs = new ArrayList<SivecModel>();
		sql = "select * from tb_sivec"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idSivec = rs.getLong(1);
				String nome = rs.getString(2);
				String sexo = rs.getString(3);
				String dtNascimento = rs.getString(4);
				String rg = rs.getString(5);
				String tipoRg = rs.getString(6);
				String dtEmissaoRg = rs.getString(7);
				String estadoCivil = rs.getString(8);
				String naturalizado = rs.getString(9);
				String grauInstrucao = rs.getString(10);
				String nomePai = rs.getString(11);
				String nomeMae = rs.getString(12);
				String corPele = rs.getString(13);
				String alcunha = rs.getString(14);
				String naturalidade = rs.getString(15);
				String postoIdentificacao = rs.getString(16);
				String formulaFundamental = rs.getString(17);
				String corOlhos = rs.getString(18);
				String cabelo = rs.getString(19);
				String profissao = rs.getString(20);
				String enderecoResidencial = rs.getString(21);
				String enderecoTrabalho = rs.getString(22);
				long idPf = rs.getLong(23);
				
				SivecModel sivec = new SivecModel(idSivec, nome, sexo, dtNascimento, rg, tipoRg, dtEmissaoRg, estadoCivil, naturalizado, grauInstrucao, nomePai, nomeMae, corPele, alcunha, naturalidade, postoIdentificacao, formulaFundamental, corOlhos, cabelo, profissao, enderecoResidencial, enderecoTrabalho, idPf);
				sivecs.add(sivec);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return sivecs;
	}
}
