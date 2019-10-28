package br.com.fiap.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.model.PJJsonModel;
import br.com.fiap.service.DBConect;

public class PJRepository {
	private Connection connection;
	private PreparedStatement p,q;
	private ResultSet rs,rsSeq;
	private String sql,sequence;
	
	public PJRepository() {
		// TODO Auto-generated constructor stub
		connection = DBConect.getConnection() ;
	}
	
	
	
	public PJJsonModel findById(long idPj) {
		PJJsonModel pj = null;
		sql = "select * from tb_pj where id_pj = ?";
		try {
			p = connection.prepareStatement(sql);
			p.setLong(1, idPj);
			rs = p.executeQuery();
			if(rs.next()) {
				String cnpj = rs.getString(2);
				String razaoSocial = rs.getString(3);
				String nomeFantasia = rs.getString(4);
				String matriculaArisp = rs.getString(5);
				Date dtConsulta = rs.getDate(6);
				String status = rs.getString(7);
				
				pj = new PJJsonModel(idPj,cnpj,razaoSocial,nomeFantasia,dtConsulta,status,matriculaArisp);
			}
		}
		catch(SQLException e) {
			System.out.println("erro ao pesquisar a empresa\n"+e);
		}
		
		return pj;
	}
	
	public void save() {
		sql="insert into tb_pf (id_pf,cpf,rg,nome,dt_nascimento,dt_consulta,status, "
				+ "nr_processo_arpensp,nr_processo_siel,pis_pasep,placa,matricula_sap "
				+ ") values (pf_seq.nextval, '123', '123','teste',TO_DATE('12/11/1999', "
				+ " 'dd/MM/yyyy'),TO_DATE(SYSDATE),'teste','12321','12312312','12312','asda123','2342342')";
	}
	
	public void saveAll(List<PJJsonModel> pessoasJ) {
		sql="insert into tb_pj (id_pj,cnpj,razao_social,nome_fantasia,matricula_arisp,dt_consulta,status"
				+ ") values (?, ?, ?, ?, ?, ?, ?)";
		sequence = "select PJ_SEQ.NEXTVAL from dual";
		try {
			
			p = connection.prepareStatement(sql);
			q = connection.prepareStatement(sequence);
			rsSeq = q.executeQuery();
			for(PJJsonModel pj:pessoasJ) {
				rsSeq.next();
				long idPj = rsSeq.getLong(1);
		
				java.sql.Date dtConsultaSql = new java.sql.Date(pj.getDtConsulta().getTime());
				p.setLong(1,idPj);
				p.setString(2, pj.getCnpj());
				p.setString(3, pj.getRazaoSocial());
				p.setString(4, pj.getNomeFantasia());
				p.setString(5, pj.getMatriculaArisp());
				p.setDate(6, dtConsultaSql);
				p.setString(7, pj.getStatus());
				p.execute();	
				rsSeq = q.executeQuery();
			}
			connection.commit();
			System.out.println("Parece q gravou certinho a lista de empresas que veio do Json, espero que sim ;X\n");
		}catch (Exception e) {
				System.out.println("Xii, deu erro pra gravar a lista de pessoas F Xo\n" + e);
		}
	}
}
