package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.SivecModel;
import br.com.fiap.service.DBConect;

public class SivecRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
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
}
