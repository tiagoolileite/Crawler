package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.PFJsonModel;
import br.com.fiap.model.RegistroArpenspModel;
import br.com.fiap.service.DBConect;

public class RegistroArpenspRepository {

	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rsSeq,rs;
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

	public List<RegistroArpenspModel> findAllById(PFJsonModel pfJson) {
		List<RegistroArpenspModel> registros = new ArrayList<RegistroArpenspModel>();
		sql = "select * from tb_arpensp"
				+ " where id_pf = ?";
		
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, pfJson.getIdPf());
			rs = p.executeQuery();
			
			while(rs.next()) {				
				long idRegistro = rs.getLong(1);
				String cartorio = rs.getString(2);
				String nrCns = rs.getString(3);
				String uf = rs.getString(4);
				String nomeConjuge1 = rs.getString(5);
				String nomeConjuge2 = rs.getString(6);
				String nvNomeConjuge2 = rs.getString(7);
				String dtCasamento = rs.getString(8);
				String matricula = rs.getString(9);
				String dtEntrada = rs.getString(10);
				String dtRegistro = rs.getString(11);
				String acervo = rs.getString(12);
				String nrLivro = rs.getString(13);
				String nrFolha = rs.getString(14);
				String nrRegistro = rs.getString(15);
				String tipoLivro = rs.getString(16);
				pfJson.setIdPf(rs.getLong(17));
				RegistroArpenspModel registro = new RegistroArpenspModel(idRegistro,cartorio,nrCns,uf,nomeConjuge1,nomeConjuge2,nvNomeConjuge2,dtCasamento,matricula,
						dtEntrada,dtRegistro,acervo,nrFolha,nrRegistro,tipoLivro, nrLivro, pfJson);
				
				registros.add(registro);
			}
		}catch (SQLException e) {
			System.out.println("Erro para buscar os registros\n" + e);
		}
		
		return registros;
	}

}
