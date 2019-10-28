package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.RegistroArpenspModel;
import br.com.fiap.service.DBConect;

public class RegistroArpenspRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq;
	private String sql,sequence;
	
	public RegistroArpenspRepository() {
		connection = DBConect.getConnection() ;
	}
	
	public void save(RegistroArpenspModel registroArpensp, PFJsonModel pf) {
		sql = "INSERT INTO TB_ARPENSP("
				+ "ID_REGISTRO, "
				+ "CARTORIO_REGISTRO, "
				+ "NR_CNS, "
				+ "UF, "
				+ "NOME_CONJUGE1, "
				+ "NOME_CONJUGE2, "
				+ "NV_NOME_CONJUGE2, "
				+ "DT_CASAMENTO, "
				+ "MATRICULA, "
				+ "DT_ENTRADA, "
				+ "DT_REGISTRO, "
				+ "ACERVO, "
				+ "NR_LIVRO, "
				+ "NR_FOLHA, "
				+ "NR_REGISTRO, "
				+ "TIPO_LIVRO, "
				+ "ID_PF) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sequence = "SELECT REGISTRO_ARPENSP_SEQ.NEXTVAL FROM DUAL";
		
		try {
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			rsSeq.next();
			
			long idRegistro = rsSeq.getLong(1);
			p.setLong(1, idRegistro);
			p.setString(2, registroArpensp.getCartorioDeRegistro());
			p.setString(3, registroArpensp.getNrCns());
			p.setString(4, registroArpensp.getUf());
			p.setString(5, registroArpensp.getNomeConjuge1());
			p.setString(6, registroArpensp.getNomeConjuge2());
			p.setString(7, registroArpensp.getNovoNomeConjuge2());
			p.setString(8, registroArpensp.getDtCasamento());
			p.setString(9, registroArpensp.getMatricula());
			p.setString(10, registroArpensp.getDtEntrada());
			p.setString(11, registroArpensp.getDtRegistro());
			p.setString(12, registroArpensp.getAcervo());
			p.setString(13, registroArpensp.getNrLivro());
			p.setString(14, registroArpensp.getNrFolha());
			p.setString(15, registroArpensp.getNrRegistro());
			p.setString(16, registroArpensp.getTipoLivro());
			p.setLong(17, pf.getIdPf());
			p.execute();
			
			connection.commit();
			System.out.println("Parece que gravou o registro do arpensp certinho da pessoa "+ pf.getNome() + ", id " + pf.getIdPf() + "\n");
		}
		catch (Exception e) {
			System.out.println("Deu pau pra gravar o registro da pessoa " + pf.getNome() + ", erro -> \n" + e);
		}
	}

}
