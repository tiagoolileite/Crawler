package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.CadespModel;
import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class CadespRepository {
	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public CadespRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void save(CadespModel cadesp, PJJsonModel pj) {
		sql = "INSERT INTO TB_CADESP("
				+ "ID_CADESP, " + 
				"IE, " + 
				"SITUACAO_CADESP, " + 
				"DT_INSCRICAO_ESTADO, " + 
				"NOME_EMPRESARIAL, " + 
				"REGIME_ESTADUAL, " + 
				"DRT, " + 
				"POSTO_FISCAL, " + 
				"NIRE, " + 
				"OCORRENCIA_FISCAL, " + 
				"TIPO_UNIDADE, " + 
				"DT_INICIO_IE, " + 
				"FOMRAS_ATUACAO, " + 
				"ID_PJ)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT CADESP_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idCadesp = rsSeq.getLong(1);
			p.setLong(1, idCadesp);
			p.setString(2, cadesp.getiE());
			p.setString(3, cadesp.getSituacaoCadesp());
			p.setString(4, cadesp.getDtInstituicaoEstado());
			p.setString(5, cadesp.getNomeEmpresarial());
			p.setString(6, cadesp.getRegimeEstadual());
			p.setString(7, cadesp.getDrt());
			p.setString(8, cadesp.getPostoFiscal());
			p.setString(9, cadesp.getNire());
			p.setString(10, cadesp.getOcorrenciaFiscal());
			p.setString(11, cadesp.getTipoUnidade());
			p.setString(12, cadesp.getDtInicioIe());
			p.setString(13, cadesp.getFormasAtuacao());
			p.setLong(14, pj.getIdPj());
			p.execute();
			
			connection.commit();
			System.out.println("Parece que gravou o cadastro da cadesp certinho da empresa "+ cadesp.getNomeEmpresarial() + ", id " + pj.getIdPj() + "\n");
		}
		catch (Exception e) {
			System.out.println("Deu pau pra gravar o registro da empresa " + cadesp.getNomeEmpresarial() + ", erro -> \n" + e);
		}
	}
}
